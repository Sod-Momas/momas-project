package cc.momas.test.newportal.web.servlet;

import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.FileItemFactory;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;

import cc.momas.test.newportal.entity.News;
import cc.momas.test.newportal.entity.News_users;
import cc.momas.test.newportal.entity.Topic;
import cc.momas.test.newportal.service.INewsService;
import cc.momas.test.newportal.service.ITopicService;
import cc.momas.test.newportal.utils.BeanFactory;
import cc.momas.test.newportal.utils.DateUtils;
import cc.momas.test.newportal.utils.Pager;

public class NewsServlet extends HttpServlet {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		this.doPost(request, response);
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		/*
		 * code 值 
		 * 1.分页查询全部新闻 
		 * 2.去添加新闻页面
		 * 3.添加新闻 
		 * 4.查询新闻详情
		 * 5.去修改新闻页面
		 * 6.修改新闻
		 * 7.删除新闻
		 * 8.退出登录
		 * 
		 */
		
		response.setContentType("text/html;charset=utf-8");
		request.setCharacterEncoding("utf-8");
		
		// 做个out
		PrintWriter out = response.getWriter();
		
		// 做个application
		ServletContext application = this.getServletContext();
		
		// 做个session
		HttpSession session = request.getSession();
		
		News_users nu = (News_users) session.getAttribute("LOGIN_USER");
		//验证登录
		if(nu==null){
			response.sendRedirect(request.getContextPath()+"/index.jsp");
		}
		
		boolean isMultipart = ServletFileUpload.isMultipartContent(request);
		String c;
		if (isMultipart) {// 如果是添加新闻页面或者有文件上传,内容会有多媒体
			c = "3";
		} else {// 普通页面只是普通值
			c = request.getParameter("code");
		}

		if (c == null || "".equals(c)) {
			c = "1";// 如果没值就默认为1
		}
		int code = Integer.parseInt(c);

		INewsService newsService = (INewsService) BeanFactory
				.getBean("newsService");
		ITopicService topicService = (ITopicService) BeanFactory
				.getBean("topicService");
		
		switch (code) {
		//1.分布查询全部新闻 
		case 1:
			// 1.获取参数并验证合法
			String s = request.getParameter("pageNo");
			Integer pageNo = null;
			if (s == null||"".equals(s)) {
				pageNo = 1;
			} else {
				pageNo = Integer.parseInt(s);
			}
			Integer pageSize = 10;// 每页10条记录

			Pager<News> pager = new Pager<News>();
			pager.setPageNo(pageNo);
			pager.setPageSize(pageSize);

			// 2.获取
			pager = newsService.queryByPager(pager);

			pager.setTotalRecoredCount(newsService.queryCountAll());// 这一步很关键设置全部页数

			// 3.将内容保存
			request.setAttribute("newspager", pager);

			// 4.转发给表示层
			request.getRequestDispatcher("/view/indexpage.jsp?pageNo=1").forward(
					request, response);

			break;
		//2.去添加新闻页面
		case 2:
			//1.接收参数并验证
			//2.验证参数
			//3.查数据
			List<Topic> tList = topicService.queryAll();

			//4.打包数据
			request.setAttribute("topicList", tList);

			//5.发送数据
			request.getRequestDispatcher("/view/add.jsp").forward(request,response);
			break;
		//3.添加新闻 
		case 3:
			String fieldName = "";// 表单字段元素的name属性值
			// 请求信息中的内容是否是multipart类型
			// boolean isMultipart =
			// ServletFileUpload.isMultipartContent(request);
			// 上传文件的存储路径(服务器文件系统上的绝对文件路径)
			String uploadFilePath = application.getRealPath("/upload/news");

			if (!isMultipart) {
				response.sendRedirect(request.getContextPath()
						+ "/servlet/newsServlet?code=1");
				return;
			}

			FileItemFactory factory = new DiskFileItemFactory();
			ServletFileUpload upload = new ServletFileUpload(factory);

			try {
				// 解析form表单中所有文件
				List<FileItem> items = upload.parseRequest(request);
				Iterator<FileItem> iter = items.iterator();
				News news = new News();

				while (iter.hasNext()) {// 依次处理每个表单字段
					FileItem item = (FileItem) iter.next();

					if (item.isFormField()) {// 普通表单字段
						fieldName = item.getFieldName();// 表单字段的name属性值
						if ("ntitle".equals(fieldName)) {
							news.setNtitle(item.getString("utf-8"));
						} else if ("ncontent".equals(fieldName)) {
							news.setNcontent(item.getString("utf-8"));
						} else if ("nsummary".equals(fieldName)) {
							news.setNsummary(item.getString("utf-8"));
						} else if ("ntid".equals(fieldName)) {
							news.setNtid(Integer.parseInt(item
									.getString("utf-8")));
						}

					} else { // 文件表单字段
						String fileName = item.getName();
						System.out.println(fileName);
						if (fileName != null && !"".equals(fileName)) {
							File fullFile = new File(fileName);
							// 获取上传文件的文件名
							String srcFilename = fullFile.getName();
							// 生成新文件名
							String newFilename = System.currentTimeMillis()
									+ srcFilename.substring(srcFilename
											.lastIndexOf("."));
							// 创建上传到服务器的目标文件
							File saveFile = new File(uploadFilePath,
									newFilename);
							// 将上传文件写入到目标文件
							item.write(saveFile);
							// 将目标文件名写到news对象,保存到数据库中
							news.setNpicPath(newFilename);
							System.out.println("文件上传成功,文件名:" + uploadFilePath + newFilename);
						}
					}
				}

				Date now = new Date();

				news.setNcreateDate(new Date(System.currentTimeMillis()));
				news.setNauthor(nu.getUname());
				news.setNcreateDate(now);
				news.setNmodifyDate(new java.sql.Date(System.currentTimeMillis()));
				newsService.insert(news);

			} catch (Exception e) {
				e.printStackTrace();
			} finally {
				response.sendRedirect(request.getContextPath()
						+ "/servlet/newsServlet?code=1");
			}
			break;
		//4.查询新闻详情
		case 4:

			// 1.接收参数
			String newsid = request.getParameter("newsid");

			// 2.验证合法性
			if (null == newsid) {
				response.sendRedirect(request.getContextPath()
						+ "/servlet/newsServlet?code=1&pageNo=1");
				return;
			}
			// 3.取值
			News n = newsService.queryById(Integer.parseInt(newsid));

			// 4.打包发送
			request.setAttribute("news", n);
			request.getRequestDispatcher("/view/newsdetails.jsp").forward(
					request, response);

			break;
		//5.去修改新闻页面
		case 5:
			//1.获取参数,验证合法
			String snid = request.getParameter("newsid");
			if(snid ==null || "".equals(snid)){
				response.sendRedirect(request.getContextPath()+"/");
				return;
			}
			//2.调用业务逻辑层完成查询
			//nid = Integer.parseInt(snid);
			
			//查询需要修改的新闻对象
			News news = newsService.queryById(Integer.parseInt(snid));
			//修改页面上要指定的话题列表
			List<Topic> topicList = topicService.queryAll();
			
			//3.保存数据到request,转发到指定视图层显示
			request.setAttribute("news",news);
			request.setAttribute("topicList",topicList);
			request.getRequestDispatcher("/view/updateNews.jsp").forward(request,response);
			break;
		//6.修改新闻
		case 6:
			//1.接收参数
			String nauthor = request.getParameter("nauthor");
			String ncontent = request.getParameter("ncontent");
			String ncreateDate = request.getParameter("ncreateDate");
			String nid = request.getParameter("nid");
			String nsummary = request.getParameter("nsummary");
			String ntid = request.getParameter("ntid");
			String ntitle = request.getParameter("ntitle");
			//2./3./4.验证合法,打包数据,调用业务层
			news =new News();
			news.setNauthor(nu.getUname());
			news.setNcontent(ncontent);
			news.setNcreateDate(DateUtils.getDateFromString(ncreateDate,"yyyy-MM-dd"));
			news.setNid(Integer.parseInt(nid));
			news.setNmodifyDate(new java.sql.Date(System.currentTimeMillis()));
			news.setNpicPath(null);
			news.setNsummary(nsummary);
			news.setNtid(Integer.parseInt(ntid));
			news.setNtitle(ntitle);
			
			int successful =  newsService.update(news);
			response.sendRedirect(request.getContextPath()+"/controller/doQuerypage.jsp?successful="+successful);
			break;
			
		// 7.删除新闻
		case 7:
			//1.获取参数
			newsid = request.getParameter("newsid");
			try {
				//2.验证合法
				if (newsid == null) {
					return;
				}
				//3.根据参数取值
				newsService.delete(Integer.parseInt(newsid));

			} catch (Exception e) {

			} finally {
				//4.转发给表示层ui
				response.sendRedirect(request.getContextPath()+"/servlet/newsServlet?code=1");
			}
			break;
		// 8.退出登录
		case 8:
			session.invalidate();
			response.sendRedirect(request.getContextPath() + "/");
			break;
		default:
			break;
		}

		out.flush();
		out.close();
	}

}

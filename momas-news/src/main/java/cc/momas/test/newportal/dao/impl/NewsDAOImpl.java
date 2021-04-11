/**
 * 
 */
package cc.momas.test.newportal.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.LinkedList;
import java.util.List;

import cc.momas.test.newportal.dao.INewsDAO;
import cc.momas.test.newportal.entity.News;
import cc.momas.test.newportal.utils.DBHelper;

/**
 * @author sod
 * 
 */
public class NewsDAOImpl implements INewsDAO {
	/**
	 * 查询所有
	 */
	public List<News> queryAll(Connection conn) {
		PreparedStatement ps = null;
		ResultSet rs = null;
		News news = null;
		List<News> nList = new LinkedList<News>();

		try {
			ps = conn.prepareStatement("SELECT * FROM news");
			rs = ps.executeQuery();

			while (rs.next()) {
				news = new News();
				news.setNauthor(rs.getString("nauthor"));
				news.setNcontent(rs.getString("ncontent"));
				news.setNcreateDate(rs.getDate("ncreateDate"));
				news.setNid(rs.getInt("nid"));
				news.setNmodifyDate(rs.getDate("nmodifyDate"));
				news.setNpicPath(rs.getString("npicPath"));
				news.setNsummary(rs.getString("nsummary"));
				news.setNtid(rs.getInt("ntid"));
				news.setNtitle(rs.getString("ntitle"));

				nList.add(news);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DBHelper.close(ps, null, rs, null);
		}

		return nList;
	}

	/**
	 * 根据条件删除记录
	 */
	public int delete(Connection conn, String sql, Object[] paras) {
		int count = 0;
		PreparedStatement ps = null;

		try {
			ps = conn.prepareStatement(sql);
			if(paras!=null){
				for (int i = 0; i < paras.length; i++) {
					ps.setObject((i + 1), paras[i]);
				}
			}
			count = ps.executeUpdate();

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DBHelper.close(ps, null, null, null);
		}

		return count;
	}

	/**
	 * 修改某记录
	 */
	public int update(Connection conn, News news) {
		String sql = "UPDATE news SET nid = nid ";
		if (news.getNtid() != null) {
			sql += " ,Ntid = " + news.getNtid();
		}
		if (news.getNtitle() != null) {
			sql += " ,Ntitle = '" + news.getNtitle() + "'";
		}
		if (news.getNauthor() != null) {
			sql += " , Nauthor = '" + news.getNauthor() + "'";
		}
		if (news.getNcreateDate() != null) {
			sql += " ,NcreateDate = '" + news.getNcreateDate() + "'";
		}
		if (news.getNcontent() != null) {
			sql += " ,Ncontent = '" + news.getNcontent() + "'";
		}
		if (news.getNpicPath() != null) {
			sql += " ,NpicPath = '" + news.getNpicPath() + "'";
		}
		if (news.getNmodifyDate() != null) {
			sql += " ,NmodifyDate = '" + news.getNmodifyDate() + "'";
		} else{
			sql+=",NmodifyDate = NULL ";
		}
		if (news.getNsummary() != null) {
			sql += " ,Nsummary = '" + news.getNsummary() + "'";
		} else {
			sql += " ,Nsummary = NULL ";
		}
		sql += " WHERE Nid = " + news.getNid();

		PreparedStatement ps = null;
		int count = -1;// 计数器

		try {
			ps = conn.prepareStatement(sql);
			count = ps.executeUpdate();

		} catch (SQLException e) {
			System.err.println("修改新闻失败");
			e.printStackTrace();
		} finally {
			DBHelper.close(ps, null, null, null);
		}
		return count;

	}

	/**
	 * 删除某记录
	 */
	public int delete(Connection conn, int id) {
		int count = -1;
		PreparedStatement ps = null;

		try {
			ps = conn.prepareStatement(" DELETE FROM news WHERE nid = " + id);
			count = ps.executeUpdate();

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DBHelper.close(ps, null, null, null);
		}
		return count;
	}

	/**
	 * 插入某记录
	 */
	public int insert(Connection conn, News news) {
		int count = -1;// 计数器
		String sql="INSERT INTO news(nid,ntid,ntitle,nauthor,ncreateDate,npicPath,ncontent,nmodifyDate,nsummary) VALUES ( ?,?,?,?,?,?,?,?,?)";//ID自增
		PreparedStatement ps = null;

		try {
			ps = conn.prepareStatement(sql);
			int index =0;
			ps.setObject(++index, null);//ID自增
			ps.setObject(++index, news.getNtid());
			ps.setObject(++index, news.getNtitle());
			ps.setObject(++index, news.getNauthor()==null?"NULL":news.getNauthor());
			ps.setObject(++index, news.getNcreateDate());
			ps.setObject(++index, news.getNpicPath()==null?"NULL":news.getNpicPath());
			ps.setObject(++index, news.getNcontent());
			ps.setObject(++index, null);
			ps.setObject(++index, news.getNsummary());
			System.out.println(sql);
			count = ps.executeUpdate();

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DBHelper.close(ps, null, null, null);
		}
		return count;
	}

	/**
	 * 根据条件查询记录
	 */
	public List<News> queryByTj(Connection conn, String sql, Object[] paras) {
		PreparedStatement ps = null;
		ResultSet rs = null;
		News news = null;
		List<News> nList = new LinkedList<News>();

		try {
			ps = conn.prepareStatement(sql);
			if(paras!=null){
				for (int i = 0; i < paras.length; i++) {
					ps.setObject((i + 1), paras[i]);
				}
			}
			rs = ps.executeQuery();

			while (rs.next()) {
				news = new News();
				news.setNauthor(rs.getString("nauthor"));
				news.setNcontent(rs.getString("ncontent"));
				news.setNcreateDate(rs.getDate("ncreateDate"));
				news.setNid(rs.getInt("nid"));
				news.setNmodifyDate(rs.getDate("nmodifyDate"));
				news.setNpicPath(rs.getString("npicPath"));
				news.setNsummary(rs.getString("nsummary"));
				news.setNtid(rs.getInt("ntid"));
				news.setNtitle(rs.getString("ntitle"));

				nList.add(news);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DBHelper.close(ps, null, rs, null);
		}

		return nList;
	}

	public int queryCountByTj(Connection conn, String sql, Object[] paras) {
		PreparedStatement ps = null;
		ResultSet rs = null;
		int count =0;

		try {
			ps = conn.prepareStatement(sql);
			if(paras!=null){
				for (int i = 0; i < paras.length; i++) {
					ps.setObject((i + 1), paras[i]);
				}
			}

			rs = ps.executeQuery();

			if(rs.next()){
				count = rs.getInt(1);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DBHelper.close(ps, null, rs, null);
		}

		return count;
	}

}

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

import cc.momas.test.newportal.dao.ICommentsDAO;
import cc.momas.test.newportal.entity.Comments;
import cc.momas.test.newportal.utils.DBHelper;

/**
 * @author sod
 * 
 */
public class CommentsDAOImpl implements ICommentsDAO {
	/**
	 * 删除一行记录
	 */
	public int delete(Connection conn, int id) {
		int count = 0;
		PreparedStatement ps = null;

		try {
			ps = conn.prepareStatement(" DELETE FROM comments WHERE cid = "
					+ id);
			count = ps.executeUpdate();

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DBHelper.close(ps, null, null, null);
		}

		return count;
	}

	public int insert(Connection conn, Comments comments) {
		int count = -1;
		PreparedStatement ps = null;
		String sql = "INSERT INTO comments VALUES(?,?,?,?,?,?);";

		try {
			ps = conn.prepareStatement(sql);

			int index = 0;
			ps.setObject(++index, "NULL");
			ps.setObject(++index, comments.getCnid());
			ps.setObject(++index, comments.getCcontent());
			ps.setObject(++index, comments.getCdate());
			ps.setObject(++index, comments.getCip());
			ps.setObject(++index, comments.getCauthor());

			count = ps.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DBHelper.close(ps, null, null, null);
		}

		return count;
	}

	public List<Comments> queryAll(Connection conn) {
		PreparedStatement ps = null;
		ResultSet rs = null;
		Comments comments = null;
		List<Comments> clist = new LinkedList<Comments>();

		try {
			ps = conn.prepareStatement("SELECT * FROM comments");
			rs = ps.executeQuery();

			while (rs.next()) {
				comments = new Comments();
				comments.setCid(rs.getInt("cid"));
				comments.setCnid(rs.getInt("cnid"));
				comments.setCcontent(rs.getString("ccontent"));
				comments.setCdate(rs.getDate("cdate"));
				comments.setCip(rs.getString("cip"));
				comments.setCauthor(rs.getString("cauthor"));

				clist.add(comments);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DBHelper.close(ps, null, rs, null);
		}
		return clist;
	}

	public List<Comments> queryByTj(Connection conn, String sql, Object[] paras) {
		PreparedStatement ps = null;
		Comments comments = null;
		ResultSet rs = null;
		List<Comments> clist = new LinkedList<Comments>();

		try {
			ps = conn.prepareStatement(sql);
			if(paras!=null){
				for (int i = 0; i < paras.length; i++) {
					ps.setObject((i + 1), paras[i]);
				}
			}
			rs = ps.executeQuery();

			while (rs.next()) {
				comments = new Comments();
				comments.setCid(rs.getInt("cid"));
				comments.setCnid(rs.getInt("cnid"));
				comments.setCcontent(rs.getString("ccontent"));
				comments.setCdate(rs.getDate("cdate"));
				comments.setCip(rs.getString("cip"));
				comments.setCauthor(rs.getString("cauthor"));

				clist.add(comments);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DBHelper.close(ps, null, rs, null);
		}
		return clist;
	}

	public int update(Connection conn, Comments comments) {
		StringBuilder sb = new StringBuilder();
		sb.append("UPDATE comments SET cid = cid");
		if (comments.getCauthor() != null) {
			sb.append(" ,Cauthor = '" + comments.getCauthor() + "'");
		}
		if (comments.getCcontent() != null) {
			sb.append(" ,Ccontent ='" + comments.getCcontent() + "'");
		}
		if (comments.getCdate() != null) {
			sb.append(" ,Cdate ='" + comments.getCdate() + "'");
		}
		if (comments.getCid() != null) {
			sb.append(" ,Cid ='" + comments.getCid() + "'");
		}
		if (comments.getCip() != null) {
			sb.append(" ,Cip ='" + comments.getCip() + "'");
		}
		sb.append(" WHERE cid = "+comments.getCid());

		PreparedStatement ps = null;
		int count = -1;

		try {
			ps = conn.prepareStatement(sb.toString());
			count = ps.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DBHelper.close(ps, null, null, null);
		}
		return count;
	}

}

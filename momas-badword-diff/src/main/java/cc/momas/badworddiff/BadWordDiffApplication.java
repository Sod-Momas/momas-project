package cc.momas.badworddiff;

import java.io.InputStream;
import java.util.HashSet;
import java.util.Set;

public class BadWordDiffApplication {

	private static Config config = new Config();
	private static FileUtil files = new FileUtil();

	public static void main(String[] args) {

		InputStream oldFileInputStream = config.getOldFile();
		InputStream newFileInputStream = config.getNewFile();
		String destFilePath = config.getDestFilePath();

		try {

			Set<Key> oldWords = files.readExcel(oldFileInputStream);
			System.out.println("旧文件词条数 ： " + oldWords.size());

			Set<Key> newWords = new HashSet<>();
			if (newFileInputStream != null) {
				newWords = files.readExcel(newFileInputStream);
			}
			System.out.println("新文件词条数 ： " + newWords.size());

			newWords.removeAll(oldWords);
			System.out.println("新增词条数 ： " + newWords.size());

			System.out.println("开始生成sql");
			String sql = setToSql(newWords);
			System.out.println("生成sql完毕,开始写入文件");
			destFilePath = files.writeToFile(destFilePath, sql);
			if (sql.contains("{ERROR}")) {
				System.out.println("生成的过程中发生了一点问题, 请在文件中搜索 {ERROR} 以定位问题sql所在位置");
			}
			System.out.println("文件写入完毕,路径为 : \r\n" + destFilePath);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * 用来生成sql
	 * @param keys 关键词集合
	 * @return sql字符串,一行一条
	 */
	public static String setToSql(Set<Key> keys) {
//		INSERT INTO hlx_badword.tb_wj_verb VALUE(null,'销售',0,NOW());
		StringBuilder sb = new StringBuilder();
		for (Key key : keys) {
			sb.append("INSERT INTO ");
			switch (key.getWordType()) {
				case Key.VERB:
					sb.append(" hlx_badword.tb_wj_verb ");
					break;
				case Key.NOUN:
					sb.append(" hlx_badword.tb_wj_noun ");
					break;
				case Key.KEYWORD:
					sb.append(" hlx_badword.tb_wj_keyword ");
					break;
				default:
					sb.append("{ERROR}");
					break;
			}

			sb.append(" VALUE(null,'");
			sb.append(key.getWord());
			sb.append("',");
			sb.append(key.getType());
			sb.append(",NOW());\r\n");
		}
		return sb.toString();
	}
}

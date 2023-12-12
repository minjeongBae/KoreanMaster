package koreanmaster.user.teacher.introduction.dao;

import koreanmaster.common.ExecuteSql;
import koreanmaster.user.teacher.introduction.dto.IntroductionDTO;

import java.sql.ResultSet;
import java.sql.SQLException;

public class IntroductionDAO {
    private final ExecuteSql executeSql;
    public IntroductionDAO() throws SQLException {
        executeSql = new ExecuteSql();
    }

    public void add(IntroductionDTO introduction){
        String sql = "INSERT INTO Introduction VALUES (" +
                "NULL, \""+ introduction.getBrief() +"\", " +
                "\""+ introduction.getTxt() +"\"," +
                "\""+ introduction.getImg() +"\"" + ");";
        executeSql.noResult(sql);
    }

    public void reviseTxt(int id, String newTxt){
        String sql = "UPDATE Introduction SET txt=\"" + newTxt + "\" WHERE introduction_id= "+ id + ";";
        executeSql.noResult(sql);
    }

    public void reviseImg(int id, String newImg){
        String sql = "UPDATE Introduction SET img=\"" + newImg + "\" WHERE introduction_id= "+ id + ";";
        executeSql.noResult(sql);
    }

    public void reviseBrief(int id, String newBrief){
        String sql = "UPDATE Introduction SET brief=\"" + newBrief + "\" WHERE introduction_id= "+ id + ";";
        executeSql.noResult(sql);
    }

    public IntroductionDTO getById(int id) throws SQLException {
        String sql = "SELECT * FROM Introduction WHERE introduction_id = " + id + ";";
        ResultSet rs = executeSql.getResult(sql);

        if(rs==null) return null;

        IntroductionDTO introduction = null;
        while (rs.next()) {
            introduction = new IntroductionDTO(
                    id, rs.getString(2),
                    rs.getString(3),
                    rs.getString(4));
        }

        return introduction;
    }
}

package com.example.dao;

import java.util.List;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import com.example.model.FacultyModel;
import com.example.model.StudentModel;
import com.example.model.StudyProgramModel;
import com.example.model.UniversityModel;

@Mapper
public interface StudentMapper
{
	@Select("select * from mahasiswa where npm = #{npm}")
    StudentModel selectStudent (@Param("npm") String npm);

    @Select("select * from mahasiswa")
    List<StudentModel> selectAllStudents ();
    
    @Insert("INSERT INTO mahasiswa (npm, nama, tempat_lahir, tanggal_lahir, jenis_kelamin, agama, golongan_darah, status, tahun_masuk, jalur_masuk, id_prodi) VALUES (#{npm}, #{nama}, #{tempat_lahir}, #{tanggal_lahir}, #{jenis_kelamin}, #{agama}, #{golongan_darah}, #{status}, #{tahun_masuk}, #{jalur_masuk}, #{id_prodi})")
    void addStudent (StudentModel student);

    @Delete("DELETE FROM mahasiswa where npm = #{npm}")
    void deleteStudent(@Param("npm") String npm);

    @Update("UPDATE mahasiswa SET npm=#{npm_baru}, nama=#{nama},tempat_lahir=#{tempat_lahir},tanggal_lahir=#{tanggal_lahir}," +
            "jenis_kelamin=#{jenis_kelamin},agama=#{agama},golongan_darah=#{golongan_darah},status=#{status}," +
            "tahun_masuk=#{tahun_masuk},jalur_masuk=#{jalur_masuk},id_prodi=#{id_prodi} WHERE npm=#{npm_lama}")
    void updateStudent( @Param("npm_lama") String npm_lama,
                        @Param("npm_baru") String npm_baru,
                        @Param("nama") String nama,
                        @Param("tempat_lahir") String tempat_lahir,
                        @Param("tanggal_lahir") String tanggal_lahir,
                        @Param("jenis_kelamin") int jenis_kelamin,
                        @Param("agama") String agama,
                        @Param("golongan_darah") String golongan_darah,
                        @Param("status") String status,
                        @Param("tahun_masuk") String tahun_masuk,
                        @Param("jalur_masuk") String jalur_masuk,
                        @Param("id_prodi") int id_prodi);
    
    @Select("select * from program_studi where id= #{id}")
    StudyProgramModel selectStudyProgram (@Param("id") int id);

    @Select("select * from fakultas where id= #{id}")
    FacultyModel selectFaculty (@Param("id") int id);

    @Select("select * from universitas where id= #{id}")
    UniversityModel selectUniversity (@Param("id") int id);
    
    @Select("SELECT substring(npm,10,3) FROM `mahasiswa` " +
            "where npm like #{npm} " +
            "order by substring(npm,10,3) desc " +
            "limit 1")
    Integer getNpm(@Param("npm") String npm);
}

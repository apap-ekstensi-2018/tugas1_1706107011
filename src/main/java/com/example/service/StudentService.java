package com.example.service;

import java.util.List;

import com.example.model.FacultyModel;
import com.example.model.StudentModel;
import com.example.model.StudyProgramModel;
import com.example.model.UniversityModel;

public interface StudentService
{
	 StudentModel selectStudent (String npm);

	 List<StudentModel> selectAllStudents ();
	 
	 void addStudent (StudentModel student);

	 void deleteStudent (String npm);

	 void updateStudent(String npm_lama, String npm_baru,String nama,String tempat_lahir,String tanggal_lahir,int jenis_kelamin,String agama,String golongan_darah,String status,String tahun_masuk,String jalur_masuk,int id_prodi);

	 StudyProgramModel selectStudyProgram(int id);

	 FacultyModel selectFaculty(int id);

	 UniversityModel selectUniversity(int id);
	 
	 Integer getNpm(String npm);

}


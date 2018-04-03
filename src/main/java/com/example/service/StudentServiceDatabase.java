package com.example.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.dao.StudentMapper;
import com.example.model.FacultyModel;
import com.example.model.StudentModel;
import com.example.model.StudyProgramModel;
import com.example.model.UniversityModel;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
public class StudentServiceDatabase implements StudentService
{
    @Autowired
    private StudentMapper studentMapper;

	@Override
	public StudentModel selectStudent(String npm) {
		// TODO Auto-generated method stub
		log.info ("select student with npm {}", npm);
        return studentMapper.selectStudent (npm);
	}

	@Override
	public List<StudentModel> selectAllStudents() {
		// TODO Auto-generated method stub
		log.info ("select all students");
        return studentMapper.selectAllStudents ();
	}

	@Override
	public void addStudent(StudentModel student) {
		// TODO Auto-generated method stub
        studentMapper.addStudent (student);

	}

	@Override
	public void deleteStudent(String npm) {
		// TODO Auto-generated method stub
		studentMapper.deleteStudent(npm);
		
	}

	@Override
	public void updateStudent(String npm_lama, String npm_baru, String nama, String tempat_lahir, String tanggal_lahir,
			int jenis_kelamin, String agama, String golongan_darah, String status, String tahun_masuk,
			String jalur_masuk, int id_prodi) {
		// TODO Auto-generated method stub
        studentMapper.updateStudent( npm_lama, npm_baru, nama, tempat_lahir, tanggal_lahir, jenis_kelamin, agama, golongan_darah, status, tahun_masuk, jalur_masuk, id_prodi);

	}

	@Override
	public StudyProgramModel selectStudyProgram(int id) {
		// TODO Auto-generated method stub
		log.info ("select student with npm {}", id);
        return studentMapper.selectStudyProgram (id);
	}

	@Override
	public FacultyModel selectFaculty(int id) {
		// TODO Auto-generated method stub
		log.info ("select student with fakultas {}", id);
        return studentMapper.selectFaculty (id);
	}

	@Override
	public UniversityModel selectUniversity(int id) {
		// TODO Auto-generated method stub
		log.info ("select student with fakultas {}", id);
        return studentMapper.selectUniversity (id);
	}

	@Override
    public Integer getNpm(String npm)
    {
        return studentMapper.getNpm(npm);
    }
   
}

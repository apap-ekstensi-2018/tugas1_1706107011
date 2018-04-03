package com.example.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.model.FacultyModel;
import com.example.model.StudentModel;
import com.example.model.StudyProgramModel;
import com.example.model.UniversityModel;
import com.example.service.StudentService;
import static org.thymeleaf.util.StringUtils.concat;

@Controller
public class StudentController
{
    String npm_generate, kode_jalur_masuk, Nomor;

    @Autowired
    StudentService studentDAO;


    @RequestMapping("/")
    public String index ()
    {
        return "index";
    }


    @RequestMapping("/mahasiswa")
    public String view (Model model,
            @RequestParam(value = "npm", required = false) String npm)
    {
        StudentModel student = studentDAO.selectStudent(npm);
        StudyProgramModel studyProgram = studentDAO.selectStudyProgram (student.getId_prodi());
        FacultyModel faculty = studentDAO.selectFaculty(studyProgram.getId_fakultas());
        UniversityModel university = studentDAO.selectUniversity(faculty.getId_univ());

        if (student != null) {
            model.addAttribute("studyProgram", studyProgram);
            model.addAttribute ("student", student);
            model.addAttribute ("faculty", faculty);
            model.addAttribute ("university", university);
            return "view";
        } else {
            model.addAttribute ("npm", npm);
            return "not-found";
        }
    }
    
    @RequestMapping("/mahasiswa/tambah")
    public String add (Model model)
    {
       return "form-add";
    }
    
    @RequestMapping(value = "/mahasiswa/tambah/submit", method = RequestMethod.POST)
    public String addSubmit (
            @RequestParam(value="nama", required = false) String nama,
            @RequestParam(value="tempat_lahir", required = false) String tempat_lahir,
            @RequestParam(value="tanggal_lahir", required = false) String tanggal_lahir,
            @RequestParam(value="jenis_kelamin", required = false) Integer jenis_kelamin,
            @RequestParam(value="agama", required = false) String agama,
            @RequestParam(value="golongan_darah", required = false) String golongan_darah,
            @RequestParam(value="tahun_masuk", required = false) String tahun_masuk,
            @RequestParam(value="jalur_masuk", required = false) String jalur_masuk,
            @RequestParam(value="id_prodi", required = false) Integer id_prodi,
            Model model)
    {
        StudyProgramModel studyProgram = studentDAO.selectStudyProgram(id_prodi);
        FacultyModel faculty = studentDAO.selectFaculty(studyProgram.getId_fakultas());
        UniversityModel university = studentDAO.selectUniversity(faculty.getId_univ());

        if(jalur_masuk.equals("Undangan Olimpiade")){
            kode_jalur_masuk = "53";
        } else if(jalur_masuk.equals("Undangan Reguler/SNMPTN")){
            kode_jalur_masuk = "54";
        } else if(jalur_masuk.equals("Undangan Paralel/PPKB")){
            kode_jalur_masuk = "55";
        } else if(jalur_masuk.equals("Ujian Tulis Bersama/SBMPTN")){
            kode_jalur_masuk = "57";
        } else if(jalur_masuk.equals("Ujian Tulis Mandiri")){
            kode_jalur_masuk = "62";
        }

        Integer urutan_npm = studentDAO.getNpm(concat("%",tahun_masuk.substring(2,4),university.getKode_univ(),studyProgram.getKode_prodi(),kode_jalur_masuk,"%"));
        if(urutan_npm != null){
            if (urutan_npm < 10){
                urutan_npm += 1;
                Nomor = concat("00",String.valueOf(urutan_npm));
            } else if(urutan_npm < 100){
                urutan_npm += 1;
                Nomor = concat("0", String.valueOf(urutan_npm));
            } else {
                urutan_npm += 1;
                Nomor = String.valueOf(urutan_npm);
            }
        }else{
            Nomor = "001";
        }
        String npm_generate = concat(tahun_masuk.substring(2,4),university.getKode_univ(),studyProgram.getKode_prodi(),kode_jalur_masuk, Nomor);

        if(npm_generate.isEmpty()){
            return "not-found";
        }else{
            StudentModel student = new StudentModel (npm_generate, nama, tempat_lahir,
                    tanggal_lahir, jenis_kelamin, agama, golongan_darah,"aktif",
                    tahun_masuk,jalur_masuk,id_prodi);
            studentDAO.addStudent (student);
            model.addAttribute("selectStudent", npm_generate);
            return "success-add";
        }
    }
    

}

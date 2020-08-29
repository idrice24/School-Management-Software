
package com.idrice24.entities;

import com.opencsv.bean.CsvBindByName;

public class Mark
{

    @CsvBindByName
    private long id;

    @CsvBindByName
    private String name;

    @CsvBindByName
    private String matricule;

    @CsvBindByName
    private String speciality;

    @CsvBindByName
    private String course;

    @CsvBindByName
    private long marks;

    @CsvBindByName
    private String evaluation;

    @CsvBindByName
    private long level;

    public Mark()
    {
    }

    public Mark(long id, String name, String matricule, String speciality, String course, long marks, String evaluation, long level)
    {
        this.id = id;
        this.name = name;
        this.matricule = matricule;
        this.speciality = speciality;
        this.course = course;
        this.marks = marks;
        this.evaluation = evaluation;
        this.level = level;
    }

    public long getId()
    {
        return id;
    }

    public void setId(long id)
    {
        this.id = id;
    }

    public String getName()
    {
        return name;
    }

    public void setName(String name)
    {
        this.name = name;
    }

    public String getMatricule()
    {
        return matricule;
    }

    public void setMatricule(String matricule)
    {
        this.matricule = matricule;
    }

    public String getSpeciality()
    {
        return speciality;
    }

    public void setSpeciality(String speciality)
    {
        this.speciality = speciality;
    }

    public String getCourse()
    {
        return course;
    }

    public void setCourse(String course)
    {
        this.course = course;
    }

    public long getMarks()
    {
        return marks;
    }

    public void setMarks(long marks)
    {
        this.marks = marks;
    }

    public void setEvaluation(String evaluation)
    {
        this.evaluation = evaluation;
    }

    public String getEvaluation()
    {
        return evaluation;
    }

    public void setLevel(long level)
    {
        this.level = level;
    }

    public long getLevel()
    {
        return level;
    }

    @Override
    public String toString()
    {
        return "Mark{" + "  id=" + id + ", name='" + name + '\'' + ", email='" + matricule + '\'' + ", speciality='" + speciality + '\'' + ", course= '" + course + '\'' + ", marks= '" + marks + '\'' + ", evaluation= '" + evaluation + '\'' + ", level= '" + level + '\'' + '}';
    }
}

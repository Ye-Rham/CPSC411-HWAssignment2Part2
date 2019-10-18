package com.cpsc411.hwasssignment2;

import android.app.Activity;
import android.os.Bundle;
import android.widget.ListView;

import com.cpsc411.hwasssignment2.adapter.SummaryLVAdapter;
import com.cpsc411.hwasssignment2.model.CourseEnrollment;
import com.cpsc411.hwasssignment2.model.Student;
import com.cpsc411.hwasssignment2.model.StudentDB;

import java.util.ArrayList;

public class MainActivity extends Activity {
    protected ListView mSummaryView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        createStudentDB();
        setContentView(R.layout.summary_listview);
        mSummaryView = findViewById(R.id.summary_list_view_id);
        SummaryLVAdapter ad = new SummaryLVAdapter();
        mSummaryView.setAdapter(ad);
    }

    protected void createStudentDB(){
        ArrayList<Student> studentList = new ArrayList<Student>();

        Student s = new Student("John", "Do", 0);
        ArrayList<CourseEnrollment> courses = new ArrayList<CourseEnrollment>();
        courses.add(new CourseEnrollment("0", "A"));
        courses.add(new CourseEnrollment("1", "B"));
        s.setCourses(courses);
        studentList.add(s);

        s = new Student("Juan", "Martinez", 1);
        courses = new ArrayList<CourseEnrollment>();
        courses.add(new CourseEnrollment("0", "B"));
        courses.add(new CourseEnrollment("1", "B"));
        s.setCourses(courses);
        studentList.add(s);

        StudentDB.getInstance().setStudents(studentList);
    }
}

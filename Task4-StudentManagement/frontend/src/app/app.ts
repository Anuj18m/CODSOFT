import { CommonModule } from '@angular/common';
import { Component, OnInit } from '@angular/core';
import { FormsModule } from '@angular/forms';

import { StudentService, Student } from './student.service';

@Component({
  selector: 'app-root',
  imports: [CommonModule, FormsModule],
  templateUrl: './app.html',
  styleUrl: './app.css'
})
export class App implements OnInit {
  students: Student[] = [];
  searchText = '';
  editMode = false;
  editId: number | null = null;

  newStudent: Student = {
    name: '',
    rollNumber: '',
    grade: ''
  };

  constructor(private studentService: StudentService) {}

  ngOnInit(): void {
    this.loadStudents();
  }

  loadStudents(): void {
    this.studentService.getStudents().subscribe((data) => {
      this.students = data;
    });
  }

  addStudent(): void {
    const name = this.newStudent.name.trim();
    const rollNumber = this.newStudent.rollNumber.trim();
    const grade = this.newStudent.grade.trim();

    if (!name || !rollNumber || !grade) {
      return;
    }

    const payload: Student = {
      name,
      rollNumber,
      grade
    };

    if (this.editMode && this.editId !== null) {
      this.studentService.updateStudent(this.editId, payload).subscribe(() => {
        this.loadStudents();
        this.resetForm();
      });
      return;
    }

    this.studentService.addStudent(payload).subscribe(() => {
      this.loadStudents();
      this.resetForm();
    });
  }

  search(): void {
    const term = this.searchText.trim();
    if (!term) {
      this.loadStudents();
      return;
    }

    this.studentService.searchStudents(term).subscribe((data) => {
      this.students = data;
    });
  }

  deleteStudent(id: number): void {
    this.studentService.deleteStudent(id).subscribe(() => {
      this.loadStudents();
    });
  }

  editStudent(student: Student): void {
    this.newStudent = {
      id: student.id,
      name: student.name,
      rollNumber: student.rollNumber,
      grade: student.grade
    };
    this.editMode = true;
    this.editId = student.id ?? null;
  }

  resetForm(): void {
    this.newStudent = { name: '', rollNumber: '', grade: '' };
    this.editMode = false;
    this.editId = null;
  }
}

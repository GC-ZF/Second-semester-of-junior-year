//#include<iostream>
//using namespace std;
//#include<string>
//
//class Student;
//class Score;
////2.��Ա������Ϊ��Ԫ����
//class Show2
//{
//public:
//	void visitinfo(Student student, Score score);
//};
//
//class Student
//{
//	friend void show(Student student, Score score);
//	friend void Show2::visitinfo(Student student, Score score);
//	friend class Show3;
//
//public:
//
//	Student(string stu_id, string stu_name)
//	{
//		this->stu_id = stu_id;
//		this->stu_name = stu_name;
//	}
//private:
//	string stu_id;
//	string stu_name;
//};
//
//class Score
//{
//	friend void show(Student student, Score score);
//	friend void Show2::visitinfo(Student student, Score score);
//	friend class Show3;
//public:
//	Score(double sc_math, double sc_english, double sc_politics, double sc_cpp)
//	{
//		this->sc_math = sc_math;
//		this->sc_english = sc_english;
//		this->sc_politics = sc_politics;
//		this->sc_cpp = sc_cpp;
//	}
//
//private:
//	double sc_math;
//	double sc_english;
//	double sc_politics;
//	double sc_cpp;
//};
//
//
//void Show2::visitinfo(Student student, Score score)
//{
//	cout << "2.��Ա������Ϊ��Ԫ����" << endl;
//	cout << "ѧ��  " << student.stu_id << "  ����  " << student.stu_name << endl;
//	cout << "����  " << score.sc_math << "  Ӣ��  " << score.sc_english << "  ����  " << score.sc_politics << "  C++  " << score.sc_cpp << endl << endl;
//}
//
//
////3.��Ԫ��
//class Show3
//{
//public:
//	void visit(Student student, Score score)
//	{
//		cout << "3.��Ԫ��" << endl;
//		cout << "ѧ��  " << student.stu_id << "  ����  " << student.stu_name << endl;
//		cout << "����  " << score.sc_math << "  Ӣ��  " << score.sc_english << "  ����  " << score.sc_politics << "  C++  " << score.sc_cpp << endl << endl;
//	}
//};
//
////1.�ǳ�Ա������Ϊ��Ԫ����
//void show(Student student, Score score)
//{
//	cout << "1.�ǳ�Ա������Ϊ��Ԫ����" << endl;
//	cout << "ѧ��  " << student.stu_id << "  ����  " << student.stu_name << endl;
//	cout << "����  " << score.sc_math << "  Ӣ��  " << score.sc_english << "  ����  " << score.sc_politics << "  C++  " << score.sc_cpp << endl << endl;
//}
//
//int main()
//{
//	Student s1("192062116", "�ŷ�");
//	Score ss1(80, 81, 82, 83);
//
//	//1.�ǳ�Ա������Ϊ��Ԫ����
//	show(s1, ss1);
//
//	//2.��Ա������Ϊ��Ԫ����
//	Show2 s2;
//	s2.visitinfo(s1, ss1);
//
//	//3.��Ԫ��
//	Show3 sh;
//	sh.visit(s1, ss1);
//
//	system("pause");
//	return 0;
//}
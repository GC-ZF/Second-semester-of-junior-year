//#include <iostream>
//using namespace std;
//#include <string>
//class Student
//{
//public:
//	Student();
//	Student(string stu_id,string stu_name,int stu_age,string stu_sex,string stu_job)
//	{
//		this->stu_id = stu_id;
//		this->stu_name = stu_name;
//		this->stu_age = stu_age;
//		this->stu_sex = stu_sex;
//		this->stu_job = stu_job;
//	}
//	void addscore();//ְ��ӷ�
//	void show();//�������
//private:
//	string stu_id;
//	string stu_name;
//	int stu_age;
//	string stu_sex="��";
//	string stu_job="ѧ��";
//	int stu_score=0;
//};
//void Student::addscore()
//{
//	string job = stu_job;
//	if (job == "ѧ��")
//		this->stu_score += 0;
//	else if (job == "�೤")
//		this->stu_score += 5;
//	else if (job == "ѧϰίԱ")
//		this->stu_score += 3;
//	else if (job == "��֧��")
//		this->stu_score += 2;
//}
//
//void Student::show()
//{
//	cout << "ѧ��\t" << stu_id << "\t����  " << stu_name << "\t����  " << stu_age << "\t�Ա�  " << stu_sex << "\tְ��  " << stu_job << "\t����  " << stu_score << endl;
//}
//
//int main()
//{
//	Student s1( "192062116","�ŷ�", 22, "��", "�೤");
//	Student s2("192062117", "�ŷ�", 21, "Ů", "ѧ��");
//
//	s1.addscore();
//	s1.show();
//
//	s2.addscore();
//	s2.show();
//
//	system("pause");
//	return 0;
//}
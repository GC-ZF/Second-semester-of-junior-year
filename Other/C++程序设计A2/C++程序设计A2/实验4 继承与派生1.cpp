//#include <iostream>
//#include <string>
//using namespace std;
//#define PI 3.1415926
//
//class Circle
//{
//public:
//	double R;
//	virtual void show() = 0;
//private:
//
//};
//
////��
//class Ball :public Circle
//{
//public:
//	Ball(double radius)
//	{
//		R = radius;
//	}
//	void show()
//	{
//		cout << "��ı����Ϊ  " << 4 * PI*R*R << "  ������Ϊ  " << 4.00 / 3.00*PI*R*R*R << endl;
//	}
//private:
//
//};
//
////Բ��
//class Cylinder :public Circle
//{
//public:
//	Cylinder(double radius, double heigh)
//	{
//		R = radius;
//		H = heigh;
//	}
//	void show()
//	{
//		cout << "Բ���ı����Ϊ  " << 2 * PI*R*R + PI * 2 * R*H << "  Բ�������Ϊ  " << PI * R*R*H << endl;
//	}
//private:
//	double H;
//};
//
////Բ׶
//class Cone :public Circle
//{
//public:
//	Cone(double radius, double heigh, double line)
//	{
//		R = radius;
//		H = heigh;
//		L = line;
//	}
//	void show()
//	{
//		cout << "Բ׶�ı����Ϊ  " << PI * R*L + PI * R*R << "  Բ׶�����Ϊ  " << PI * R*R*H / 3 << endl;
//	}
//private:
//	double H;
//	double L;
//};
//
//int main()
//{
//	Circle * ball = new Ball(2);
//	ball->show();
//	delete ball;
//
//	Circle * cylinder = new Cylinder(2, 2);
//	cylinder->show();
//	delete cylinder;
//
//	Circle * cone = new Cone(2, 2, 2);
//	cone->show();
//	delete cone;
//
//	system("pause");
//	return 0;
//}
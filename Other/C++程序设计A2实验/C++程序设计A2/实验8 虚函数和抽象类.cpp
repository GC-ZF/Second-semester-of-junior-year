//#include<iostream>
//using namespace std;
//#define PI 3.1415926
//
//class CBase
//{
//public:
//	virtual void area() = 0;
//	virtual void circum() = 0;
//};
//
//class Triangle :public CBase
//{
//public:
//	Triangle(double d, double h, double a, double b, double c)
//	{
//		this->d = d;
//		this->h = h;
//		this->a = a;
//		this->b = b;
//		this->c = c;
//	}
//	void area()
//	{
//		cout << "�����ε����Ϊ" << d * h/2 << endl;
//	}
//	void circum()
//	{
//		cout << "�����ε��ܳ�Ϊ" << a + b + c << endl;
//	}
//private:
//	double d;
//	double h;
//	double a;//����������a,b,c
//	double b;
//	double c;
//};
//
//class Cube :public CBase
//{
//public:
//	Cube(double c)
//	{
//		this->c = c;
//	}
//	void area()
//	{
//		cout << "�����ε����Ϊ" << c * c << endl;
//	}
//	void circum()
//	{
//		cout << "�����ε��ܳ�Ϊ" << 4 * c << endl;
//	}
//private:
//	double c;
//};
//
//class Circle :public CBase
//{
//public:
//	Circle(double r)
//	{
//		this->r = r;
//	}
//	void area()
//	{
//		cout << "Բ�����Ϊ" << PI * r*r << endl;
//	}
//	void circum()
//	{
//		cout << "Բ���ܳ�Ϊ" << 2 * PI*r << endl;
//	}
//private:
//	double r;
//};
//int main()
//{
//	CBase * t = new Triangle(3, 4, 3, 4, 5);
//	t->area();
//	t->circum();
//	delete t;
//
//	CBase * c = new Cube(1);
//	c->area();
//	c->circum();
//	delete c;
//
//	CBase * cir = new Circle(1);
//	cir->area();
//	cir->circum();
//	delete cir;
//
//	system("pause");
//	return 0;
//}
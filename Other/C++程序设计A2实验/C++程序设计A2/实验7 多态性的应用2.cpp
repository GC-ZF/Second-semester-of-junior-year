//#include<iostream>
//using namespace std;
//
////��״
//class Shape
//{
//public:
//	virtual void show() = 0;
//};
//
////����
//class Point:public Shape
//{
//public:
//	Point(){};
//	Point(double x, double y)
//	{
//		this->x = x;
//		this->y = y;
//	}
//	void setP(double x,double y)
//	{
//		this->x = x;
//		this->y = y;
//	}
//	void show()
//	{
//		cout << "����һ����" << endl;
//	}
//	friend ostream &operator <<(ostream &out, Point &p0);
//private:
//	double x, y;
//	
//};
//
//ostream &operator <<(ostream &out, Point &p0)
//{
//	out <<"("<< p0.x<<","<<p0.y<<")";
//	return out;
//}
//
////Բ��
//class Circle:public Point
//{
//public:
//	Circle() {};
//	Circle(double r,double x,double y)
//	{
//		this->r = r;
//		setP(x, y);
//	}
//	void setR(double r)
//	{
//		this->r = r;
//	}
//	void show()
//	{
//		cout << "����һ��Բ" << endl;
//	}
//private:
//	double r;
//};
//
////Բ����
//class  Cylinder:public Circle
//{
//public:
//	Cylinder(double x,double y,double r, double h)
//	{
//		setP(x, y);
//		setR(r);
//		this->h = h;
//	}
//	void show()
//	{
//		cout << "����һ��Բ����" << endl;
//	}
//private:
//	double h;
//};
//
//
//int main()
//{
//	Point p2(0, 0);
//	p2.show();
//	cout << "�������������  p=" << p2<< endl;
//
//	Circle c1(2, 2, 2);
//	c1.show();
//
//	Shape * c = new Circle(3,3,3);//Բ
//	c->show();
//	delete c;
//
//	Shape * cy = new Cylinder(4, 4, 4, 4);//Բ����
//	cy->show();
//	delete cy;
//
//	system("pause");
//	return 0;
//}
//#include<iostream>
//using namespace std;
//
//class Point
//{
//private:
//	double x, y;
//public:
//	Point() {};
//	Point(double x, double y)
//	{
//		this->x = x;
//		this->y = y;
//	}
//	void show()
//	{
//		cout << "(" << this->x << "," << this->y << ")" << endl;
//	}
//	Point operator + (Point &p2) 
//	{
//		Point p;
//		p.x =x+ p2.x;
//		p.y =y+ p2.y;
//		return p;
//	}
//	Point operator - (Point &p2)
//	{
//		Point p;
//		p.x = x - p2.x;
//		p.y = y - p2.y;
//		return p;
//	}
//	//ǰ��
//	Point operator ++()
//	{
//		//�ȼ�
//		x++;
//		y++;
//		//��ʹ��
//		return *this;
//	}
//	//����
//	Point operator ++(int)
//	{
//		//��ʹ��(����)
//		Point temp=*this;
//		//���
//		++(*this);
//		return temp;
//	}
//	//ǰ��
//	Point operator --()
//	{
//		x--;
//		y--;
//		return *this;
//	}
//	//���
//	Point operator --(int)
//	{
//		Point temp = *this;
//		--(*this);
//		return temp;
//	}
//};
//
//int main()
//{
//	Point p0(1, 1);
//	Point p1(1, 1);
//	cout << "p0";
//	p0.show();
//	cout << "p1";
//	p1.show();
//	cout << "p0+p1=";
//	Point p2 = p0 + p1;
//	p2.show();
//	Point p3 = p1 - p0;
//	cout << "p1-p0=";
//	p3.show();
//	cout << "++p0:";
//	(++p0).show();
//	cout << "p0++:";
//	(p0++).show();
//	cout << "p0++��p0:";
//	p0.show();
//	cout << "--p1:";
//	(--p1).show();
//	cout << "p1--:";
//	(p1--).show();
//	cout << "p1--��p1:";
//	p1.show();
//	
//	system("pause");
//	return 0;
//}

//#include<iostream>
//using namespace std;
//
//class Point
//{
//private:
//	double x, y;
//public:
//	
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
//	friend Point operator + (Point &p1,Point &p2);
//	friend Point operator - (Point &p1, Point &p2);
//	friend Point operator ++(Point &p0);
//	friend Point operator ++(Point &p0,int);
//	friend Point operator --(Point &p0);
//	friend Point operator --(Point &p0,int);
//	friend ostream& operator <<(ostream &out, Point &p0);
//	friend istream &operator>>(istream &in, Point &p0);
//};
//Point operator + (Point &p1, Point &p2)
//{
//	Point p;
//	p.x = p1.x + p2.x;
//	p.y = p1.y + p2.y;
//	return p;
//}
//Point operator - (Point &p1, Point &p2)
//{
//	Point p;
//	p.x = p1.x - p2.x;
//	p.y = p1.y - p2.y;
//	return p;
//}
////ǰ��
//Point operator ++(Point &p0)
//{
//	//�ȼ�
//	p0.x++;
//	p0.y++;
//	//��ʹ��
//	return p0;
//}
////����
//Point operator ++(Point &p0,int)
//{
//	//��ʹ��(����)
//	Point temp = p0;
//	//���
//	p0.x++;
//	p0.y++;
//	return temp;
//}
////ǰ��
//Point operator --(Point &p0)
//{
//	p0.x--;
//	p0.y--;
//	return p0;
//}
////���
//Point operator --(Point &p0,int)
//{
//	Point temp = p0;
//	p0.x--;
//	p0.y--;
//	return temp;
//}
//
//ostream &operator <<(ostream &out, Point &p0)
//{
//	out <<"("<< p0.x<<","<<p0.y<<")";
//	return out;
//}
//istream &operator>>(istream &in, Point &p0)
//{
//	in >> p0.x >> p0.y;
//	return in;
//}
//int main()
//{
//	Point p0;
//	cout << "����p0" << endl;
//	cin >> p0;//��ȡ���������
//	cout << "p0="<< p0 << endl;//���������������
//
//	Point p1;
//	cout << "����p1" << endl;
//	cin >> p1;//��ȡ���������
//	cout << "p1=" << p1 << endl;//���������������
//	
//	Point p3 = p0 + p1;//�ӷ�����
//	cout << "p3=p0+p1=" << p3 << endl;
//	Point p4 = p0 - p1;//��������
//	cout << "p4=p0-p1=" << p4 << endl;
//	cout << "++p0:";//ǰ��++
//	(++p0).show();
//	cout << "p0++:";//����++
//	(p0++).show();
//	cout << "p0++��p0:";
//	p0.show();
//	cout << "--p1:";//ǰ��--
//	(--p1).show();
//	cout << "p1--:";//����--
//	(p1--).show();
//	cout << "p1--��p1:";
//	p1.show();
//
//
//	system("pause");
//	return 0;
//}

//#include "iostream"
//
//using namespace std;
//
//class complex
//{
//public:
//	complex(double a = 0.0, double b = 0.0) : real(a), img(b) {};
//
//public:
//	friend complex operator+(const complex &A, const complex &B);
//	friend complex operator-(const complex &A, const complex &B);
//	friend complex operator*(const complex &A, const complex &B);
//	friend complex operator/(const complex &A, const complex &B);
//	friend istream &operator>>(istream &in, complex &A);
//	friend ostream &operator<<(ostream &out, complex &A);
//
//private:
//	double real;
//	double img;
//};
//
//// ���ؼӷ������
//complex operator+(const complex &A, const complex &B)
//{
//	complex C;
//	C.real = A.real + B.real;
//	C.img = A.img + B.img;
//	return C;
//}
//// ���ؼ��������
//complex operator-(const complex &A, const complex &B)
//{
//	complex C;
//	C.real = A.real - B.real;
//	C.img = A.img - B.img;
//	return C;
//}
//
//// ���س˷������
//complex operator*(const complex &A, const complex &B)
//{
//	complex C;
//	C.real = A.real * B.real - A.img * B.img;
//	C.img = A.img * B.real + A.real * B.img;
//	return C;
//}
//
//// ���س��������
//complex operator/(const complex &A, const complex &B)
//{
//	complex C;
//	double square = A.real * A.real + A.img * A.img;
//	C.real = (A.real * B.real + A.img * B.img) / square;
//	C.img = (A.img * B.real - A.real * B.img) / square;
//	return C;
//}
//
//// �������������
//istream &operator>>(istream &in, complex &A)
//{
//	in >> A.real >> A.img;
//	return in;
//}
//
//// ������������
//ostream &operator<<(ostream &out, complex &A)
//{
//	out << A.real << " + " << A.img << "i";
//	return out;
//}
//
//int main()
//{
//	complex c1, c2, c3;
//	cin >> c1 >> c2;
//
//	c3 = c1 + c2;
//	cout << "c1 + c2 = " << c3 << endl;
//
//	c3 = c1 - c2;
//	cout << "c1 - c2 = " << c3 << endl;
//
//	c3 = c1 * c2;
//	cout << "c1 * c2 = " << c3 << endl;
//
//	c3 = c1 / c2;
//	cout << "c1 / c2 = " << c3 << endl;
//
//	return 0;
//}

#include <iostream>
using namespace std;
#include<string>
#include <fstream>
#define MAX 200	//ÿһ����Ա����100

//����ȫ�ֺ���
void Statistics();//ͳ�ƺ���
void Statisticstotal();//ͳ��������
void Statisticman();//ͳ����Ա��
void Statisticwomen();//ͳ��ŮԱ��
void Statisticage();//ͳ�������
//�� ��
class Person
{
public:
	string id;	//���
	string name;//����
	string sex;//�Ա�
	int age;  //����
};

//��ʦ��
class Teacher :virtual public Person
{
	friend class Tea_Po; //������Ԫ����ʦ��������Ա����ʽ�ʦ˽�б���
public:
	void Add();//���
	void Seach();//��ѯ
	void Show();//��ʾ
	void Edit();//�༭
	void Delete();//ɾ��
	void Save();//����
	void Read();//��ȡ
	void Seachid();//��Ų�ѯ
	void Seachname();//������ѯ
	void Showone();
private:
	string t_dept;//����ϵ��
	string t_major;//רҵ
	string t_title;//ְ��
}; Teacher Tea[MAX]; int Teatop = 0;

void Teacher::Add()
{
	Teacher t_temp;//��ʱ����
	if (Teatop < MAX)
	{
		cout << "���:"; cin >> id;
		for (int i = 0; i < Teatop; i++)
		{
			if (Tea[i].id == id)
			{
				cout << "id�Ѵ���" << endl;
				return;
			}
		}
		t_temp.id = id;
		cout << "����:"; cin >> t_temp.name;
		cout << "�Ա�:"; cin >> t_temp.sex;
		cout << "����:"; cin >> t_temp.age;
		cout << "ϵ��:"; cin >> t_temp.t_dept;
		cout << "רҵ:"; cin >> t_temp.t_major;
		cout << "ְ��:"; cin >> t_temp.t_title;
		Tea[Teatop] = t_temp;
		Teatop++;
	}
	else
	{
		cout << "��ǰ��ʦ������" << endl;
	}
}
void Teacher::Seach()
{
	while (true)
	{
		int c;
		cout << endl;
		cout << "  |������������������������������|" << endl;
		cout << "  |      ��ʦ����ƽ̨-��ѯ       |" << endl;
		cout << "  |   1.��Ų�ѯ                 |" << endl;
		cout << "  |   2.������ѯ                 |" << endl;
		cout << "  |   0.�˳�                     |" << endl;
		cout << "  |______________________________|" << endl << endl;
		cout << "��ѡ��"; cin >> c;
		switch (c)
		{
		case 1:
			Seachid();
			break;
		case 2:
			Seachname();
			break;
		case 0:
			return;
			break;
		default:
			cout << "�����������������" << endl;
			break;
		}
	}
}
void Teacher::Show()
{
	if (Teatop == 0)
	{
		cout << "��ǰ��ʦϵͳ��Ϊ��" << endl;
	}
	else
	{
		for (int i = 0; i < Teatop; i++)
		{
			Tea[i].Showone();
		}
	}
}
void Teacher::Edit()
{
	Teacher t_temp;
	while (true)
	{
		int c;
		cout << endl;
		cout << "  |������������������������������|" << endl;
		cout << "  |      ��ʦ����ƽ̨-�༭       |" << endl;
		cout << "  |   1.���ݱ�Ų�ѯ���޸�       |" << endl;
		cout << "  |   2.����������ѯ���޸�       |" << endl;
		cout << "  |   0.�˳�                     |" << endl;
		cout << "  |______________________________|" << endl << endl;
		cout << "��ѡ��"; cin >> c;
		if (c == 1)
		{
			string sid;
			int i;
			cout << "��������"; cin >> sid;
			for (i = 0; i < Teatop; i++)
			{
				if (Tea[i].id == sid)
					break;
			}
			if (i == Teatop)
				cout << "��������Ч��ϵͳ�ڲ�����" << endl;
			else
			{
				cout << "���:"; cin >> t_temp.id;
				cout << "����:"; cin >> t_temp.name;
				cout << "�Ա�:"; cin >> t_temp.sex;
				cout << "����:"; cin >> t_temp.age;
				cout << "ϵ��:"; cin >> t_temp.t_dept;
				cout << "רҵ:"; cin >> t_temp.t_major;
				cout << "ְ��:"; cin >> t_temp.t_title;
				Tea[i] = t_temp;
			}
			break;
		}
		else if (c == 2)
		{
			string sname;
			int i;
			cout << "����������"; cin >> sname;
			for (i = 0; i < Teatop; i++)
			{
				if (Tea[i].name == sname)
					break;
			}
			if (i == Teatop)
				cout << "��������Ч��ϵͳ�ڲ�����" << endl;
			else
			{
				cout << "���:"; cin >> t_temp.id;
				cout << "����:"; cin >> t_temp.name;
				cout << "�Ա�:"; cin >> t_temp.sex;
				cout << "����:"; cin >> t_temp.age;
				cout << "ϵ��:"; cin >> t_temp.t_dept;
				cout << "רҵ:"; cin >> t_temp.t_major;
				cout << "ְ��:"; cin >> t_temp.t_title;
				Tea[i] = t_temp;
			}
			break;
		}
		else if (c == 0)
		{
			break;
		}
		else
		{
			cout << "�������������ѡ��" << endl;
		}
	}
}
void Teacher::Delete()
{
	Teacher t_temp;
	if (Teatop == 0)
	{
		cout << "��ǰ��¼Ϊ��" << endl;
		return;
	}
	while (true)
	{
		int c;
		cout << endl;
		cout << "  |������������������������������|" << endl;
		cout << "  |      ��ʦ����ƽ̨-ɾ��       |" << endl;
		cout << "  |   1.���ݱ�Ų�ѯ��ɾ��       |" << endl;
		cout << "  |   2.����������ѯ��ɾ��       |" << endl;
		cout << "  |   0.�˳�                     |" << endl;
		cout << "  |______________________________|" << endl << endl;
		cout << "��ѡ��"; cin >> c;
		if (c == 1)
		{
			string sid;
			int i;
			cout << "��������"; cin >> sid;
			for (i = 0; i < Teatop; i++)
			{
				if (Tea[i].id == sid)
					break;
			}
			if (i == Teatop)
				cout << "��������Ч��ϵͳ�ڲ�����" << endl;
			else
			{
				for (i; i < Teatop; i++)
				{
					Tea[i] = Tea[i + 1];
				}
				cout << "ɾ���ɹ�" << endl;
				Teatop--;
			}
			break;
		}
		else if (c == 2)
		{
			string sname;
			int i;
			cout << "����������"; cin >> sname;
			for (i = 0; i < Teatop; i++)
			{
				if (Tea[i].name == sname)
					break;
			}
			if (i == Teatop)
				cout << "����������Ч��ϵͳ�ڲ�����" << endl;
			else
			{
				for (i; i < Teatop; i++)
				{
					Tea[i] = Tea[i + 1];
				}
				Teatop--;
			}
			break;
		}
		else if (c == 0)
		{
			break;
		}
		else
		{
			cout << "�������������ѡ��" << endl;
		}
	}
}

void Teacher::Save()
{
	int i;
	ofstream outfile, outfile1;
	outfile1.open("Teatop.dat", ios::out);	//д�ļ�Teatop.dat
	outfile1 << Teatop;
	outfile.open("Tea_data.dat", ios::binary);
	if (!outfile)
	{
		cerr << "open error!" << endl; return;
	}
	for (i = 0; i < Teatop; i++)
		outfile.write((char *)&Tea[i], sizeof(Tea[i]));
	outfile.close();
	cout << "����ɹ���" << endl;
}
void Teacher::Read()
{
	int i;
	ifstream infile, infile1;
	infile1.open("Teatop.dat", ios::in);
	infile1 >> Teatop;
	infile.open("Tea_data.dat", ios::binary);
	if (!infile)
	{
		cerr << "open error!" << endl; return;
	}
	for (i = 0; i < Teatop; i++)
		infile.read((char *)&Tea[i], sizeof(Tea[i]));
	infile.close();
	cout << "��ȡ�ɹ���" << endl;
}
void Teacher::Seachid()
{
	string sid;
	cout << "��������" << endl; cin >> sid;
	int i;
	for (i = 0; i < Teatop; i++)
	{
		if (Tea[i].id == sid)
		{
			Tea[i].Showone();
			break;
		}
	}
	if (i == Teatop)
	{
		cout << "�ñ�Ų�����" << endl;
	}
}
void Teacher::Seachname()
{
	string sname;
	cout << "����������" << endl; cin >> sname;
	int i;
	for (i = 0; i < Teatop; i++)
	{
		if (Tea[i].name == sname)
		{
			Tea[i].Showone();
			break;
		}
	}
	if (i == Teatop)
	{
		cout << "������������" << endl;
	}
}
void Teacher::Showone()
{
	cout << "���\t" << id << "\t����\t" << name << "\t�Ա�\t" << sex << "\t����\t" << age << "\tϵ��\t" << t_dept << "\tרҵ\t" << t_major << "\tְ��\t" << t_title << endl;
}

//ʵ����Ա��
class Experiment :public Person
{
public:
	void Add();//���
	void Seach();//��ѯ
	void Show();//��ʾ
	void Edit();//�༭
	void Delete();//ɾ��
	void Save();//����
	void Read();//��ȡ
	void Seachid();//��Ų�ѯ
	void Seachname();//������ѯ
	void Showone();
private:
	string e_location;//����ʵ����
	string e_job;//ְ��
}; Experiment Exper[MAX]; int Expertop;

void Experiment::Add()
{
	Experiment e_temp;//��ʱ����
	if (Expertop < MAX)
	{
		cout << "���:"; cin >> id;
		for (int i = 0; i < Expertop; i++)
		{
			if (Exper[i].id == id)
			{
				cout << "id�Ѵ���" << endl;
				return;
			}
		}
		e_temp.id = id;
		cout << "����:"; cin >> e_temp.name;
		cout << "�Ա�:"; cin >> e_temp.sex;
		cout << "����:"; cin >> e_temp.age;
		cout << "ʵ����:"; cin >> e_temp.e_location;
		cout << "ְ��:"; cin >> e_temp.e_job;
		Exper[Expertop] = e_temp;
		Expertop++;
	}
	else
	{
		cout << "��ǰʵ����Ա������" << endl;
	}
}
void Experiment::Seach()
{
	while (true)
	{
		int c;
		cout << endl;
		cout << "  |������������������������������|" << endl;
		cout << "  |  ʵ����Ա����ƽ̨-��ѯ       |" << endl;
		cout << "  |   1.��Ų�ѯ                 |" << endl;
		cout << "  |   2.������ѯ                 |" << endl;
		cout << "  |   0.�˳�                     |" << endl;
		cout << "  |______________________________|" << endl << endl;
		cout << "��ѡ��"; cin >> c;
		switch (c)
		{
		case 1:
			Seachid();
			break;
		case 2:
			Seachname();
			break;
		case 0:
			return;
			break;
		default:
			cout << "�����������������" << endl;
			break;
		}
	}
}
void Experiment::Show()
{
	if (Expertop == 0)
	{
		cout << "��ǰʵ����Աϵͳ��Ϊ��" << endl;
	}
	else
	{
		for (int i = 0; i < Expertop; i++)
		{
			Exper[i].Showone();
		}
	}
}
void Experiment::Edit()
{
	Experiment e_temp;
	while (true)
	{
		int c;
		cout << endl;
		cout << "  |������������������������������|" << endl;
		cout << "  |  ʵ����Ա����ƽ̨-�༭       |" << endl;
		cout << "  |   1.���ݱ�Ų�ѯ���޸�       |" << endl;
		cout << "  |   2.����������ѯ���޸�       |" << endl;
		cout << "  |   0.�˳�                     |" << endl;
		cout << "  |______________________________|" << endl << endl;
		cout << "��ѡ��"; cin >> c;
		if (c == 1)
		{
			string sid;
			int i;
			cout << "��������"; cin >> sid;
			for (i = 0; i < Expertop; i++)
			{
				if (Exper[i].id == sid)
					break;
			}
			if (i == Expertop)
				cout << "��������Ч��ϵͳ�ڲ�����" << endl;
			else
			{
				cout << "���:"; cin >> e_temp.id;
				cout << "����:"; cin >> e_temp.name;
				cout << "�Ա�:"; cin >> e_temp.sex;
				cout << "����:"; cin >> e_temp.age;
				cout << "ʵ����:"; cin >> e_temp.e_location;
				cout << "ְ��:"; cin >> e_temp.e_job;
				Exper[i] = e_temp;
			}
			break;
		}
		else if (c == 2)
		{
			string sname;
			int i;
			cout << "����������"; cin >> sname;
			for (i = 0; i < Expertop; i++)
			{
				if (Exper[i].name == sname)
					break;
			}
			if (i == Expertop)
				cout << "��������Ч��ϵͳ�ڲ�����" << endl;
			else
			{
				cout << "���:"; cin >> e_temp.id;
				cout << "����:"; cin >> e_temp.name;
				cout << "�Ա�:"; cin >> e_temp.sex;
				cout << "����:"; cin >> e_temp.age;
				cout << "ʵ����:"; cin >> e_temp.e_location;
				cout << "ְ��:"; cin >> e_temp.e_job;
				Exper[i] = e_temp;
			}
			break;
		}
		else if (c == 0)
		{
			break;
		}
		else
		{
			cout << "�������������ѡ��" << endl;
		}
	}
}
void Experiment::Delete()
{
	Experiment e_temp;
	if (Expertop == 0)
	{
		cout << "��ǰ��¼Ϊ��" << endl;
		return;
	}
	while (true)
	{
		int c;
		cout << endl;
		cout << "  |������������������������������|" << endl;
		cout << "  |   ʵ����Ա����ƽ̨-ɾ��      |" << endl;
		cout << "  |   1.���ݱ�Ų�ѯ��ɾ��       |" << endl;
		cout << "  |   2.����������ѯ��ɾ��       |" << endl;
		cout << "  |   0.�˳�                     |" << endl;
		cout << "  |______________________________|" << endl << endl;
		cout << "��ѡ��"; cin >> c;
		if (c == 1)
		{
			string sid;
			int i;
			cout << "��������"; cin >> sid;
			for (i = 0; i < Expertop; i++)
			{
				if (Exper[i].id == sid)
					break;
			}
			if (i == Expertop)
				cout << "��������Ч��ϵͳ�ڲ�����" << endl;
			else
			{
				for (i; i < Expertop; i++)
				{
					Exper[i] = Exper[i + 1];
				}
				cout << "ɾ���ɹ�" << endl;
				Expertop--;
			}
			break;
		}
		else if (c == 2)
		{
			string sname;
			int i;
			cout << "����������"; cin >> sname;
			for (i = 0; i < Expertop; i++)
			{
				if (Exper[i].name == sname)
					break;
			}
			if (i == Expertop)
				cout << "����������Ч��ϵͳ�ڲ�����" << endl;
			else
			{
				for (i; i < Expertop; i++)
				{
					Exper[i] = Exper[i + 1];
				}
				Expertop--;
			}
			break;
		}
		else if (c == 0)
		{
			break;
		}
		else
		{
			cout << "�������������ѡ��" << endl;
		}
	}
}

void Experiment::Save()
{
	int i;
	ofstream outfile, outfile1;
	outfile1.open("Expertop.dat", ios::out);	//д�ļ�Expertop.dat
	outfile1 << Expertop;
	outfile.open("Exper_data.dat", ios::binary);
	if (!outfile)
	{
		cerr << "open error!" << endl; return;
	}
	for (i = 0; i < Expertop; i++)
		outfile.write((char *)&Exper[i], sizeof(Exper[i]));
	outfile.close();
	cout << "����ɹ���" << endl;
}
void Experiment::Read()
{
	int i;
	ifstream infile, infile1;
	infile1.open("Expertop.dat", ios::in);
	infile1 >> Expertop;
	infile.open("Exper_data.dat", ios::binary);
	if (!infile)
	{
		cerr << "open error!" << endl; return;
	}
	for (i = 0; i < Expertop; i++)
		infile.read((char *)&Exper[i], sizeof(Exper[i]));
	infile.close();
	cout << "��ȡ�ɹ���" << endl;
}
void Experiment::Seachid()
{
	string sid;
	cout << "��������" << endl; cin >> sid;
	int i;
	for (i = 0; i < Expertop; i++)
	{
		if (Exper[i].id == sid)
		{
			Exper[i].Showone();
			break;
		}
	}
	if (i == Expertop)
	{
		cout << "�ñ�Ų�����" << endl;
	}
}
void Experiment::Seachname()
{
	string sname;
	cout << "����������" << endl; cin >> sname;
	int i;
	for (i = 0; i < Expertop; i++)
	{
		if (Exper[i].name == sname)
		{
			Exper[i].Showone();
			break;
		}
	}
	if (i == Expertop)
	{
		cout << "������������" << endl;
	}
}
void Experiment::Showone()
{
	cout << "���\t" << id << "\t����\t" << name << "\t�Ա�\t" << sex << "\t����\t" << age << "\tʵ����\t" << e_location << "\tְ��\t" << e_job << endl;
}

//������Ա��
class Politician :virtual public Person
{
	friend class Tea_Po;//������Ԫ����ʦ��������Ա�����������Ա˽�б���
public:
	void Add();//���
	void Seach();//��ѯ
	void Show();//��ʾ
	void Edit();//�༭
	void Delete();//ɾ��
	void Save();//����
	void Read();//��ȡ
	void Seachid();//��Ų�ѯ
	void Seachname();//������ѯ
	void Showone();
private:
	string p_look;//������ò
	string p_post;//ְ��
}; Politician Po[MAX]; int Potop;

void Politician::Add()
{
	Politician p_temp;//��ʱ����
	if (Potop < MAX)
	{
		cout << "���:"; cin >> id;
		for (int i = 0; i < Potop; i++)
		{
			if (Po[i].id == id)
			{
				cout << "id�Ѵ���" << endl;
				return;
			}
		}
		p_temp.id = id;
		cout << "����:"; cin >> p_temp.name;
		cout << "�Ա�:"; cin >> p_temp.sex;
		cout << "����:"; cin >> p_temp.age;
		cout << "������ò:"; cin >> p_temp.p_look;
		cout << "ְ��:"; cin >> p_temp.p_post;
		Po[Potop] = p_temp;
		Potop++;
	}
	else
	{
		cout << "��ǰ������Ա������" << endl;
	}
}
void Politician::Seach()
{
	while (true)
	{
		int c;
		cout << endl;
		cout << "  |������������������������������|" << endl;
		cout << "  |  ������Ա����ƽ̨-��ѯ       |" << endl;
		cout << "  |   1.��Ų�ѯ                 |" << endl;
		cout << "  |   2.������ѯ                 |" << endl;
		cout << "  |   0.�˳�                     |" << endl;
		cout << "  |______________________________|" << endl << endl;
		cout << "��ѡ��"; cin >> c;
		switch (c)
		{
		case 1:
			Seachid();
			break;
		case 2:
			Seachname();
			break;
		case 0:
			return;
			break;
		default:
			cout << "�����������������" << endl;
			break;
		}
	}
}
void Politician::Show()
{
	if (Potop == 0)
	{
		cout << "��ǰ������Աϵͳ��Ϊ��" << endl;
	}
	else
	{
		for (int i = 0; i < Potop; i++)
		{
			Po[i].Showone();
		}
	}
}
void Politician::Edit()
{
	Politician p_temp;
	while (true)
	{
		int c;
		cout << endl;
		cout << "  |������������������������������|" << endl;
		cout << "  |  ������Ա����ƽ̨-�༭       |" << endl;
		cout << "  |   1.���ݱ�Ų�ѯ���޸�       |" << endl;
		cout << "  |   2.����������ѯ���޸�       |" << endl;
		cout << "  |   0.�˳�                     |" << endl;
		cout << "  |______________________________|" << endl << endl;
		cout << "��ѡ��"; cin >> c;
		if (c == 1)
		{
			string sid;
			int i;
			cout << "��������"; cin >> sid;
			for (i = 0; i < Potop; i++)
			{
				if (Po[i].id == sid)
					break;
			}
			if (i == Potop)
				cout << "��������Ч��ϵͳ�ڲ�����" << endl;
			else
			{
				cout << "���:"; cin >> p_temp.id;
				cout << "����:"; cin >> p_temp.name;
				cout << "�Ա�:"; cin >> p_temp.sex;
				cout << "����:"; cin >> p_temp.age;
				cout << "������ò:"; cin >> p_temp.p_look;
				cout << "ְ��:"; cin >> p_temp.p_post;
				Po[i] = p_temp;
			}
			break;
		}
		else if (c == 2)
		{
			string sname;
			int i;
			cout << "����������"; cin >> sname;
			for (i = 0; i < Potop; i++)
			{
				if (Po[i].name == sname)
					break;
			}
			if (i == Potop)
				cout << "��������Ч��ϵͳ�ڲ�����" << endl;
			else
			{
				cout << "���:"; cin >> p_temp.id;
				cout << "����:"; cin >> p_temp.name;
				cout << "�Ա�:"; cin >> p_temp.sex;
				cout << "����:"; cin >> p_temp.age;
				cout << "������ò:"; cin >> p_temp.p_look;
				cout << "ְ��:"; cin >> p_temp.p_post;
				Po[i] = p_temp;
			}
			break;
		}
		else if (c == 0)
		{
			break;
		}
		else
		{
			cout << "�������������ѡ��" << endl;
		}
	}
}
void Politician::Delete()
{
	Politician p_temp;
	if (Potop == 0)
	{
		cout << "��ǰ��¼Ϊ��" << endl;
		return;
	}
	while (true)
	{
		int c;
		cout << endl;
		cout << "  |������������������������������|" << endl;
		cout << "  |   ������Ա����ƽ̨-ɾ��      |" << endl;
		cout << "  |   1.���ݱ�Ų�ѯ��ɾ��       |" << endl;
		cout << "  |   2.����������ѯ��ɾ��       |" << endl;
		cout << "  |   0.�˳�                     |" << endl;
		cout << "  |______________________________|" << endl << endl;
		cout << "��ѡ��"; cin >> c;
		if (c == 1)
		{
			string sid;
			int i;
			cout << "��������"; cin >> sid;
			for (i = 0; i < Potop; i++)
			{
				if (Po[i].id == sid)
					break;
			}
			if (i == Potop)
				cout << "��������Ч��ϵͳ�ڲ�����" << endl;
			else
			{
				for (i; i < Potop; i++)
				{
					Po[i] = Po[i + 1];
				}
				cout << "ɾ���ɹ�" << endl;
				Potop--;
			}
			break;
		}
		else if (c == 2)
		{
			string sname;
			int i;
			cout << "����������"; cin >> sname;
			for (i = 0; i < Potop; i++)
			{
				if (Po[i].name == sname)
					break;
			}
			if (i == Potop)
				cout << "����������Ч��ϵͳ�ڲ�����" << endl;
			else
			{
				for (i; i < Potop; i++)
				{
					Po[i] = Po[i + 1];
				}
				Potop--;
			}
			break;
		}
		else if (c == 0)
		{
			break;
		}
		else
		{
			cout << "�������������ѡ��" << endl;
		}
	}
}

void Politician::Save()
{
	int i;
	ofstream outfile, outfile1;
	outfile1.open("Potop.dat", ios::out);	//д�ļ�Potop.dat
	outfile1 << Potop;
	outfile.open("Po_data.dat", ios::binary);
	if (!outfile)
	{
		cerr << "open error!" << endl; return;
	}
	for (i = 0; i < Potop; i++)
		outfile.write((char *)&Po[i], sizeof(Po[i]));
	outfile.close();
	cout << "����ɹ���" << endl;
}
void Politician::Read()
{
	int i;
	ifstream infile, infile1;
	infile1.open("Potop.dat", ios::in);
	infile1 >> Potop;
	infile.open("Po_data.dat", ios::binary);
	if (!infile)
	{
		cerr << "open error!" << endl; return;
	}
	for (i = 0; i < Potop; i++)
		infile.read((char *)&Po[i], sizeof(Po[i]));
	infile.close();
	cout << "��ȡ�ɹ���" << endl;
}
void Politician::Seachid()
{
	string sid;
	cout << "��������" << endl; cin >> sid;
	int i;
	for (i = 0; i < Potop; i++)
	{
		if (Po[i].id == sid)
		{
			Po[i].Showone();
			break;
		}
	}
	if (i == Potop)
	{
		cout << "�ñ�Ų�����" << endl;
	}
}
void Politician::Seachname()
{
	string sname;
	cout << "����������" << endl; cin >> sname;
	int i;
	for (i = 0; i < Potop; i++)
	{
		if (Po[i].name == sname)
		{
			Po[i].Showone();
			break;
		}
	}
	if (i == Potop)
	{
		cout << "������������" << endl;
	}
}
void Politician::Showone()
{
	cout << "���\t" << id << "\t����\t" << name << "\t�Ա�\t" << sex << "\t����\t" << age << "\t������ò\t" << p_look << "\tְ��\t" << p_post << endl;
}


//��ʦ��������Ա��
class Tea_Po :public Teacher,Politician
{
public:
	void Add();//���
	void Seach();//��ѯ
	void Show();//��ʾ
	void Edit();//�༭
	void Delete();//ɾ��,����
	void Save();//����
	void Read();//��ȡ
	void Seachid();//��Ų�ѯ
	void Seachname();//������ѯ
	void Showone();
}; Tea_Po T_P[MAX]; int T_Ptop;



void Tea_Po::Add()
{
	Tea_Po tp_temp;//��ʱ����
	if (T_Ptop < MAX)
	{
		cout << "���:"; cin >> id;
		for (int i = 0; i < T_Ptop; i++)
		{
			if (T_P[i].id == id)
			{
				cout << "id�Ѵ���" << endl;
				return;
			}
		}
		tp_temp.id = id;
		cout << "����:"; cin >> tp_temp.name;
		cout << "�Ա�:"; cin >> tp_temp.sex;
		cout << "����:"; cin >> tp_temp.age;
		cout << "ϵ��:"; cin >> tp_temp.t_dept;
		cout << "רҵ:"; cin >> tp_temp.t_major;
		cout << "������ò:"; cin >> tp_temp.p_look;
		cout << "ְ��:"; cin >> tp_temp.p_post;
		T_P[T_Ptop] = tp_temp;
		T_Ptop++;
	}
	else
	{
		cout << "��ǰ��ʦ��������Ա������" << endl;
	}
}
void Tea_Po::Seach()
{
	while (true)
	{
		int c;
		cout << endl;
		cout << "  |������������������������������|" << endl;
		cout << "  |  ��ʦ��������Ա����ƽ̨-��ѯ       |" << endl;
		cout << "  |   1.��Ų�ѯ                 |" << endl;
		cout << "  |   2.������ѯ                 |" << endl;
		cout << "  |   0.�˳�                     |" << endl;
		cout << "  |______________________________|" << endl << endl;
		cout << "��ѡ��"; cin >> c;
		switch (c)
		{
		case 1:
			Seachid();
			break;
		case 2:
			Seachname();
			break;
		case 0:
			return;
			break;
		default:
			cout << "�����������������" << endl;
			break;
		}
	}
}
void Tea_Po::Show()
{
	if (T_Ptop == 0)
	{
		cout << "��ǰ��ʦ��������Աϵͳ��Ϊ��" << endl;
	}
	else
	{
		for (int i = 0; i < T_Ptop; i++)
		{
			T_P[i].Showone();
		}
	}
}
void Tea_Po::Edit()
{
	Tea_Po tp_temp;
	while (true)
	{
		int c;
		cout << endl;
		cout << "  |������������������������������|" << endl;
		cout << "  |  ��ʦ��������Ա����ƽ̨-�༭       |" << endl;
		cout << "  |   1.���ݱ�Ų�ѯ���޸�       |" << endl;
		cout << "  |   2.����������ѯ���޸�       |" << endl;
		cout << "  |   0.�˳�                     |" << endl;
		cout << "  |______________________________|" << endl << endl;
		cout << "��ѡ��"; cin >> c;
		if (c == 1)
		{
			string sid;
			int i;
			cout << "��������"; cin >> sid;
			for (i = 0; i < T_Ptop; i++)
			{
				if (T_P[i].id == sid)
					break;
			}
			if (i == T_Ptop)
				cout << "��������Ч��ϵͳ�ڲ�����" << endl;
			else
			{
				cout << "���:"; cin >> tp_temp.id;
				cout << "����:"; cin >> tp_temp.name;
				cout << "�Ա�:"; cin >> tp_temp.sex;
				cout << "����:"; cin >> tp_temp.age;
				cout << "ϵ��:"; cin >> tp_temp.t_dept;
				cout << "רҵ"; cin >> tp_temp.t_major;
				cout << "������ò:"; cin >> tp_temp.p_look;
				cout << "ְ��:"; cin >> tp_temp.p_post;
				T_P[i] = tp_temp;
			}
			break;
		}
		else if (c == 2)
		{
			string sname;
			int i;
			cout << "����������"; cin >> sname;
			for (i = 0; i < T_Ptop; i++)
			{
				if (T_P[i].name == sname)
					break;
			}
			if (i == T_Ptop)
				cout << "��������Ч��ϵͳ�ڲ�����" << endl;
			else
			{
				cout << "���:"; cin >> tp_temp.id;
				cout << "����:"; cin >> tp_temp.name;
				cout << "�Ա�:"; cin >> tp_temp.sex;
				cout << "����:"; cin >> tp_temp.age;
				cout << "ϵ��:"; cin >> tp_temp.t_dept;
				cout << "רҵ"; cin >> tp_temp.t_major;
				cout << "������ò:"; cin >> tp_temp.p_look;
				cout << "ְ��:"; cin >> tp_temp.p_post;
				T_P[i] = tp_temp;
			}
			break;
		}
		else if (c == 0)
		{
			break;
		}
		else
		{
			cout << "�������������ѡ��" << endl;
		}
	}
}
void Tea_Po::Delete()
{
	Tea_Po tp_temp;
	if (T_Ptop == 0)
	{
		cout << "��ǰ��¼Ϊ��" << endl;
		return;
	}
	while (true)
	{
		int c;
		cout << endl;
		cout << "  |������������������������������|" << endl;
		cout << "  |   ��ʦ��������Ա����ƽ̨-ɾ��      |" << endl;
		cout << "  |   1.���ݱ�Ų�ѯ��ɾ��       |" << endl;
		cout << "  |   2.����������ѯ��ɾ��       |" << endl;
		cout << "  |   0.�˳�                     |" << endl;
		cout << "  |______________________________|" << endl << endl;
		cout << "��ѡ��"; cin >> c;
		if (c == 1)
		{
			string sid;
			int i;
			cout << "��������"; cin >> sid;
			for (i = 0; i < T_Ptop; i++)
			{
				if (T_P[i].id == sid)
					break;
			}
			if (i == T_Ptop)
				cout << "��������Ч��ϵͳ�ڲ�����" << endl;
			else
			{
				for (i; i < T_Ptop; i++)
				{
					T_P[i] = T_P[i + 1];
				}
				cout << "ɾ���ɹ�" << endl;
				T_Ptop--;
			}
			break;
		}
		else if (c == 2)
		{
			string sname;
			int i;
			cout << "����������"; cin >> sname;
			for (i = 0; i < T_Ptop; i++)
			{
				if (T_P[i].name == sname)
					break;
			}
			if (i == T_Ptop)
				cout << "����������Ч��ϵͳ�ڲ�����" << endl;
			else
			{
				for (i; i < T_Ptop; i++)
				{
					T_P[i] = T_P[i + 1];
				}
				T_Ptop--;
			}
			break;
		}
		else if (c == 0)
		{
			break;
		}
		else
		{
			cout << "�������������ѡ��" << endl;
		}
	}
}

void Tea_Po::Save()
{
	int i;
	ofstream outfile, outfile1;
	outfile1.open("T_Ptop.dat", ios::out);	//д�ļ�T_Ptop.dat
	outfile1 << T_Ptop;
	outfile.open("T_P_data.dat", ios::binary);
	if (!outfile)
	{
		cerr << "open error!" << endl; return;
	}
	for (i = 0; i < T_Ptop; i++)
		outfile.write((char *)&T_P[i], sizeof(T_P[i]));
	outfile.close();
	cout << "����ɹ���" << endl;
}
void Tea_Po::Read()
{
	int i;
	ifstream infile, infile1;
	infile1.open("T_Ptop.dat", ios::in);
	infile1 >> T_Ptop;
	infile.open("T_P_data.dat", ios::binary);
	if (!infile)
	{
		cerr << "open error!" << endl; return;
	}
	for (i = 0; i < T_Ptop; i++)
		infile.read((char *)&T_P[i], sizeof(T_P[i]));
	infile.close();
	cout << "��ȡ�ɹ���" << endl;
}
void Tea_Po::Seachid()
{
	string sid;
	cout << "��������" << endl; cin >> sid;
	int i;
	for (i = 0; i < T_Ptop; i++)
	{
		if (T_P[i].id == sid)
		{
			T_P[i].Showone();
			break;
		}
	}
	if (i == T_Ptop)
	{
		cout << "�ñ�Ų�����" << endl;
	}
}
void Tea_Po::Seachname()
{
	string sname;
	cout << "����������" << endl; cin >> sname;
	int i;
	for (i = 0; i < T_Ptop; i++)
	{
		if (T_P[i].name == sname)
		{
			T_P[i].Showone();
			break;
		}
	}
	if (i == T_Ptop)
	{
		cout << "������������" << endl;
	}
}
void Tea_Po::Showone()
{
	cout << "���\t" << id << "\t����\t" << name << "\t�Ա�\t" << sex << "\t����\t" << age <<"\tϵ��\t"<<t_dept<<"\tרҵ"<<t_major<< "\t������ò\t" << p_look << "\tְ��\t" << p_look << endl;
}

/*�ֱ����������Ա�Ĳ˵�
��ʦ�˵�	void Tea_menu(Teacher tea)
ʵ����Ա�˵�void Exper_menu(Experiment exper)
������Ա�˵�void P_menu(Politician po)
��ʦ��������Ա�˵�void TeaPo_menu(Tea_Po t_p)
*/

//��ʦ�˵�
void Tea_menu(Teacher tea)
{
	while (true)
	{
		system("pause");
		system("cls");//������˵�
		int c;
		cout << endl;
		cout << "  |������������������������������|" << endl;
		cout << "  |      ��ʦ����ƽ̨            |" << endl;
		cout << "  |   1.���                     |" << endl;
		cout << "  |   2.��ѯ                     |" << endl;
		cout << "  |   3.��ʾ                     |" << endl;
		cout << "  |   4.�༭                     |" << endl;
		cout << "  |   5.ɾ��                     |" << endl;
		cout << "  |   6.ͳ��                     |" << endl;
		cout << "  |   7.����                     |" << endl;
		cout << "  |   8.��ȡ                     |" << endl;
		cout << "  |   0.�˳�                     |" << endl;
		cout << "  |______________________________|" << endl << endl;
		cout << "��ѡ��"; cin >> c;
		switch (c)
		{
		case 1:
			tea.Add();
			break;
		case 2:
			tea.Seach();
			break;
		case 3:
			tea.Show();
			break;
		case 4:
			tea.Edit();
			break;
		case 5:
			tea.Delete();
			break;
		case 6:
			Statistics();
			break;
		case 7:
			tea.Save();
			break;
		case 8:
			tea.Read();
			break;
		case 0:
			break;
		default:
			cout << "�����������������" << endl;
			break;
		}
		if (c == 0)
			break;
	}
}

//ʵ����Ա�˵�
void Exper_menu(Experiment exper)
{
	while (true)
	{
		system("pause");
		system("cls");//������˵�
		int c;
		cout << endl;
		cout << "  |������������������������������|" << endl;
		cout << "  |      ʵ����Ա����ƽ̨        |" << endl;
		cout << "  |   1.���                     |" << endl;
		cout << "  |   2.��ѯ                     |" << endl;
		cout << "  |   3.��ʾ                     |" << endl;
		cout << "  |   4.�༭                     |" << endl;
		cout << "  |   5.ɾ��                     |" << endl;
		cout << "  |   6.ͳ��                     |" << endl;
		cout << "  |   7.����                     |" << endl;
		cout << "  |   8.��ȡ                     |" << endl;
		cout << "  |   0.�˳�                     |" << endl;
		cout << "  |______________________________|" << endl << endl;
		cout << "��ѡ��"; cin >> c;
		switch (c)
		{
		case 1:
			exper.Add();
			break;
		case 2:
			exper.Seach();
			break;
		case 3:
			exper.Show();
			break;
		case 4:
			exper.Edit();
			break;
		case 5:
			exper.Delete();
			break;
		case 6:
			Statistics();
			break;
		case 7:
			exper.Save();
			break;
		case 8:
			exper.Read();
			break;
		case 0:
			break;
		default:
			cout << "�����������������" << endl;
			break;
		}
		if (c == 0)
			break;
	}
}

//������Ա��˵�
void P_menu(Politician po)
{
	while (true)
	{
		system("pause");
		system("cls");//������˵�
		int c;
		cout << endl;
		cout << "  |������������������������������|" << endl;
		cout << "  |      ������Ա����ƽ̨        |" << endl;
		cout << "  |   1.���                     |" << endl;
		cout << "  |   2.��ѯ                     |" << endl;
		cout << "  |   3.��ʾ                     |" << endl;
		cout << "  |   4.�༭                     |" << endl;
		cout << "  |   5.ɾ��                     |" << endl;
		cout << "  |   6.ͳ��                     |" << endl;
		cout << "  |   7.����                     |" << endl;
		cout << "  |   8.��ȡ                     |" << endl;
		cout << "  |   0.�˳�                     |" << endl;
		cout << "  |______________________________|" << endl << endl;
		cout << "��ѡ��"; cin >> c;
		switch (c)
		{
		case 1:
			po.Add();
			break;
		case 2:
			po.Seach();
			break;
		case 3:
			po.Show();
			break;
		case 4:
			po.Edit();
			break;
		case 5:
			po.Delete();
			break;
		case 6:
			Statistics();
			break;
		case 7:
			po.Save();
			break;
		case 8:
			po.Read();
			break;
		case 0:
			break;
		default:
			cout << "�����������������" << endl;
			break;
		}
		if (c == 0)
			break;
	}
}


//��ʦ��������Ա�˵�
void TeaPo_menu(Tea_Po t_p)
{
	while (true)
	{
		system("pause");
		system("cls");//������˵�
		int c;
		cout << endl;
		cout << "  |������������������������������|" << endl;
		cout << "  |  ��ʦ��������Ա��Ա����ƽ̨  |" << endl;
		cout << "  |   1.���                     |" << endl;
		cout << "  |   2.��ѯ                     |" << endl;
		cout << "  |   3.��ʾ                     |" << endl;
		cout << "  |   4.�༭                     |" << endl;
		cout << "  |   5.ɾ��                     |" << endl;
		cout << "  |   6.ͳ��                     |" << endl;
		cout << "  |   7.����                     |" << endl;
		cout << "  |   8.��ȡ                     |" << endl;
		cout << "  |   0.�˳�                     |" << endl;
		cout << "  |______________________________|" << endl << endl;
		cout << "��ѡ��"; cin >> c;
		switch (c)
		{
		case 1:
			t_p.Add();
			break;
		case 2:
			t_p.Seach();
			break;
		case 3:
			t_p.Show();
			break;
		case 4:
			t_p.Edit();
			break;
		case 5:
			t_p.Delete();
			break;
		case 6:
			Statistics();
			break;
		case 7:
			t_p.Save();
			break;
		case 8:
			t_p.Read();
			break;
		case 0:
			break;
		default:
			cout << "�����������������" << endl;
			break;
		}
		if (c == 0)
			break;
	}
}



void Statistics()
{
	while (true)
	{
		int c;
		cout << endl;
		cout << "  |������������������������������|" << endl;
		cout << "  |      ����ͳ��                |" << endl;
		cout << "  |   1.������Ա����             |" << endl;
		cout << "  |   2.��Ա������               |" << endl;
		cout << "  |   3.ŮԱ������               |" << endl;
		cout << "  |   4.ĳ���������             |" << endl;
		cout << "  |   0.�˳�                     |" << endl;
		cout << "  |______________________________|" << endl << endl;
		cout << "��ѡ��"; cin >> c;
		switch (c)
		{
		case 1:
			Statisticstotal();
			break;
		case 2:
			Statisticman();
			break;
		case 3:
			Statisticwomen();
			break;
		case 4:
			Statisticage();
			break;
		case 0:
			return;
			break;
		default:
			cout << "�����������������" << endl;
			break;
		}
	}
}
//����Ա������
void Statisticstotal()
{
	cout << "����Ա��������" << Teatop + Expertop + Potop + T_Ptop << endl;
	cout << "��ʦ������" << Teatop << endl;
	cout << "ʵ��Ա������" << Expertop << endl;
	cout << "������Ա������" << Potop << endl;
	cout << "��ʦ��������Ա������" << T_Ptop << endl;
}
//��Ա������
void Statisticman()
{
	int man = 0;
	for (int i = 0; i < Teatop; i++)
	{
		if (Tea[i].sex == "��")
			man++;
	}
	for (int i = 0; i < Expertop; i++)
	{
		if (Exper[i].sex == "��")
			man++;
	}
	for (int i = 0; i < Potop; i++)
	{
		if (Po[i].sex == "��")
			man++;
	}
	for (int i = 0; i < T_Ptop; i++)
	{
		if (T_P[i].sex == "��")
			man++;
	}
	cout << "��Ա��������Ϊ" << man << endl;
}
//ŮԱ������
void Statisticwomen()
{
	int women = 0;
	for (int i = 0; i < Teatop; i++)
	{
		if (Tea[i].sex == "Ů")
			women++;
	}
	for (int i = 0; i < Expertop; i++)
	{
		if (Exper[i].sex == "Ů")
			women++;
	}
	for (int i = 0; i < Potop; i++)
	{
		if (Po[i].sex == "Ů")
			women++;
	}
	for (int i = 0; i < T_Ptop; i++)
	{
		if (T_P[i].sex == "Ů")
			women++;
	}
	cout << "ŮԱ��������Ϊ" << women << endl;
}
//�����ͳ��
void Statisticage()
{
	int age1, age2;
	cout << "��������:age1="; cin >> age1;
	cout << "��������:age2="; cin >> age2;
	int num = 0;
	for (int i = 0; i < Teatop; i++)
	{
		if (Tea[i].age > age1&& Tea[i].age < age2)
			num++;
	}
	for (int i = 0; i < Expertop; i++)
	{
		if (Exper[i].age > age1&&Exper[i].age < age2)
			num++;
	}
	for (int i = 0; i < Potop; i++)
	{
		if (Po[i].age > age1&&Po[i].age < age2)
			num++;
	}
	for (int i = 0; i < T_Ptop; i++)
	{
		if (T_P[i].age > age1&&T_P[i].age < age2)
			num++;
	}
	cout << age1 << "��" << age2 << "������Ϊ" << num << endl;
}
int main()
{
	string password = "1";	//��ʼ����
	string inputpass;	//��������
	int f = 3;			//�������
	int c;		//���˵�ѡ��

	//����������Ա,���ò˵�
	Teacher mt;
	Experiment me;
	Politician mp;
	Tea_Po mtp;

	cout << endl;
	cout << "  |������������������������������|" << endl;
	cout << "  |      ��У��Ա��Ϣ����ϵͳ    |" << endl;
	cout << "  |______________________________|" << endl << endl;

	while (true)
	{
		cout << "����������" << endl; cin >> inputpass;
		if (inputpass == password)
		{
			cout << "������ȷ" << endl;
			break;
		}
		else
		{
			cout << "�������" << endl;
			if (f > 1)
			{
				cout << "�㻹��" << f - 1 << "�λ���" << endl;
				f--;
			}
			else
				exit(0);
		}
	}
	system("pause");
	while (true)
	{
		system("cls");
		cout << endl;
		cout << "  |������������������������������|" << endl;
		cout << "  |      ��У��Ա��Ϣ����ϵͳ    |" << endl;
		cout << "  |   1.��ʦ����                 |" << endl;
		cout << "  |   2.ʵ��Ա����               |" << endl;
		cout << "  |   3.������Ա����             |" << endl;
		cout << "  |   4.��ʦ��������Ա�������   |" << endl;
		cout << "  |   0.�˳�                     |" << endl;
		cout << "  |______________________________|" << endl << endl;
		cout << "��ѡ��" << endl;
		cin >> c;
		switch (c)
		{
		case 1:
			Tea_menu(mt);
			break;
		case 2:
			Exper_menu(me);
			break;
		case 3:
			P_menu(mp);
			break;
		case 4:
			TeaPo_menu(mtp);
			break;
		case 0:break;
		default:
			cout << "�����������������" << endl;
			system("pause");
			break;
		}
		if (c == 0)
			break;
	}


	return 0;
}
package ����ϵͳʵ��;

import java.util.Arrays;
import java.util.Scanner;
import java.util.LinkedList;

/*
 * ��̬�����㷨 FF NF BF WF
 * @author CSDN ��ʱ��
 * @data 2021��12��9��
 */
public class ��̬�����㷨 {
	public static void main(String[] args) {
		Memory my = new Memory();// �½�һ���ڴ����
		Scanner sc = new Scanner(System.in);
		while (true) {
			System.out.println("������Ҫ�����ڴ滹��Ҫ�ͷ��ڴ�");
			System.out.println("1.�����ڴ� 2.�ͷ��ڴ� 3.չʾ����״��");
			int n = sc.nextInt();
			switch (n) {
			case 1: {
				System.out.println("������Ҫ������ڴ��С");
				int size = sc.nextInt();
				my.allocation(size);// ���ö���Memory���ڴ���亯��allocation
				my.showZones();// չʾ����״��
				break;
			}
			case 2: {
				System.out.println("������Ҫ�ͷ��ڴ�ķ�����");
				int id = sc.nextInt();
				my.collection(id);// ���ö���Memory���ڴ��ͷź���collection
				break;
			}
			case 3: {
				my.showZones();// չʾ����״��
				break;
			}
			default:
				System.out.println("��Ĳ���");
			}
		}
	}
}

//�½�һ���ڴ���
class Memory {
	private int size;// �ڴ��С
	private static final int MIN_SIZE = 2;// ��Сʣ�������С
	private LinkedList<Zone> zones;// �ڴ����
	private int pointer;// �ϴη���Ŀ�����λ��

	// �½�һ���ڲ��࣬�����ڵ���
	class Zone {
		private int size;// ������С
		private int head;// ����ʼַ
		private boolean isFree;// ����״̬

		public Zone(int head, int size) {
			this.head = head;
			this.size = size;
			this.isFree = true;
		}
	}

	// Ĭ���ڴ��С512K
	public Memory() {
		this.size = 512;
		this.pointer = 0;// Ĭ���״����г����ϴη���Ŀ�����λ��Ϊ0
		this.zones = new LinkedList<>();
		zones.add(new Zone(0, size));
	}

	public Memory(int size) {
		this.size = size;
		this.pointer = 0;
		this.zones = new LinkedList<>();
		zones.add(new Zone(0, size));
	}

	// �ڴ����˵�
	public void allocation(int size) {
		System.out.println("1.�״���Ӧ�㷨 2.ѭ���״���Ӧ�㷨 3.�����Ӧ�㷨 4.���Ӧ�㷨");
		System.out.print("��ѡ������㷨:");
		Scanner in = new Scanner(System.in);
		int choice = in.nextInt();
		switch (choice) {
		case 1:
			FF(size);
			break;
		case 2:
			NF(size);
			break;
		case 3:
			BF(size);
			break;
		case 4:
			WF(size);
			break;
		default:
			System.out.println("������ѡ��!");
		}
	}

	// �״���Ӧ�㷨
	private void FF(int size) {
		// ������������
		for (pointer = 0; pointer < zones.size(); pointer++) {
			Zone tmp = zones.get(pointer);
			// �ҵ����÷����������Ҵ�С�㹻��
			if (tmp.isFree && (tmp.size > size)) {
				doAllocation(size, pointer, tmp);
				return;
			}
		}
		// ����������δ�ҵ����÷���, ���ڴ����ʧ��
		System.out.println("�޿����ڴ�ռ�!");
	}

	// ѭ���״���Ӧ�㷨
	private void NF(int size) {
		Zone tmp = zones.get(pointer);
		if (tmp.isFree && (tmp.size > size)) {
			doAllocation(size, pointer, tmp);
			return;
		}
		int len = zones.size();
		int i = (pointer + 1) % len;
		for (; i != pointer; i = (i + 1) % len) {
			tmp = zones.get(i);
			if (tmp.isFree && (tmp.size > size)) {
				doAllocation(size, i, tmp);
				return;
			}
		}
		// ȫ���������δ������ʧ��
		System.out.println("�޿����ڴ�ռ�!");
	}

	// �����Ӧ�㷨
	private void BF(int size) {
		int flag = -1;
		int min = this.size;
		for (pointer = 0; pointer < zones.size(); pointer++) {
			Zone tmp = zones.get(pointer);
			if (tmp.isFree && (tmp.size > size)) {
				if (min > tmp.size - size) {
					min = tmp.size - size;
					flag = pointer;
				}
			}
		}
		if (flag == -1) {
			System.out.println("�޿����ڴ�ռ�!");
		} else {
			doAllocation(size, flag, zones.get(flag));
		}
	}

	// ���Ӧ�㷨
	private void WF(int size) {
		int flag = -1;
		int max = 0;
		for (pointer = 0; pointer < zones.size(); pointer++) {
			Zone tmp = zones.get(pointer);
			if (tmp.isFree && (tmp.size > size)) {
				if (max < tmp.size - size) {
					max = tmp.size - size;
					flag = pointer;
				}
			}
		}
		if (flag == -1) {
			System.out.println("�޿����ڴ�ռ�!");
		} else {
			doAllocation(size, flag, zones.get(flag));
		}
	}

	// ��ʼ����
	private void doAllocation(int size, int location, Zone tmp) {
		// Ҫ��ʣ�ı���С����MIN_SIZEС�����ʣ���ǵ��ǰһ������
		if (tmp.size - size <= MIN_SIZE) {
			tmp.isFree = false;
		} else {
			Zone split = new Zone(tmp.head + size, tmp.size - size);
			zones.add(location + 1, split);
			tmp.size = size;
			tmp.isFree = false;
		}
		System.out.println("�ɹ����� " + size + "KB �ڴ�!");
	}

	// �ڴ����
	public void collection(int id) {
		if (id >= zones.size()) {
			System.out.println("�޴˷������!");
			return;
		}
		Zone tmp = zones.get(id);
		int size = tmp.size;
		if (tmp.isFree) {
			System.out.println("ָ������δ������, �������");
			return;
		}
		// ������յķ�����һ���ǿ��оͺͺ�һ���ϲ�
		if (id < zones.size() - 1 && zones.get(id + 1).isFree) {
			Zone next = zones.get(id + 1);
			tmp.size += next.size;
			zones.remove(next);
		}
		// ���յķ���Ҫ��ǰһ���ǿ��оͺ�ǰ�����ϲ�
		if (id > 0 && zones.get(id - 1).isFree) {
			Zone previous = zones.get(id - 1);
			previous.size += tmp.size;
			zones.remove(id);
			id--;
		}
		zones.get(id).isFree = true;
		System.out.println("�ڴ���ճɹ�!, ���λ����� " + size + "KB �ռ�!");
	}

	// չʾ����״��
	public void showZones() {
		System.out.println("�������\t    ����ʼַ\t     ������С\t ����״̬\t");
		for (int i = 0; i < zones.size(); i++) {
			Zone tmp = zones.get(i);
			System.out.println(i + "\t\t" + tmp.head + "\t\t" + tmp.size + "  \t" + tmp.isFree);
		}
	}
}

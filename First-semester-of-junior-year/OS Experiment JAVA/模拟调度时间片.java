package ����ϵͳʵ��;

import java.text.DecimalFormat;
import java.util.Arrays;
import java.util.Scanner;

/*
 * ģ�����ʱ��Ƭ
 * @author ��ʱ��
 * @data 2021��12��16��
 */
public class ģ�����ʱ��Ƭ {
	public static void main(String[] args) {
		// ����������̣�attribure��ʾ����ʱ�䣬����ʱ��
		attribute[] ab = { 
				new attribute(1, 5),
				new attribute(8, 5),
				new attribute(10, 5),
				new attribute(16, 15),
				new attribute(14, 25) };
		utils.runattribute(ab);// ѡ������ʽ
	}
}

//Ϊ���̶���һ������
class attribute {
	static int runname = -1;// ����ǰ����������
	int Run_time;// ��Ҫ����ʱ��
	int input_time;// ����ʱ��
	int name = -1;// �������

	public int getName() {
		return name;
	}

	public void setName(int name) {
		this.name = name;
	}

	public attribute() {
	}

	public attribute(int input_time, int run_time) {
		this.Run_time = run_time;
		this.input_time = input_time;
		runname++;
		this.name = runname + 0;

	}

	public int getRun_time() {
		return Run_time;
	}

	public void setRun_time(int run_time) {
		Run_time = run_time;
	}

	public int getInput_time() {
		return input_time;
	}

	public void setInput_time(int input_time) {
		this.input_time = input_time;
	}
}

class utils {
	// ������OutputAttribute
	public static void OutputAttribute(attribute[] ab) {
		int time = ab[0].input_time;
		int TimeSum[] = new int[ab.length];// ��ҵ����תʱ��
		double DTimeSum[] = new double[ab.length];// ��Ȩ��ת��ʱ��
		System.out.print("����ID ");
		System.out.print("����ʱ�� ");
		System.out.print("����ʱ�� ");
		System.out.print("���ʱ�� ");
		System.out.print("��תʱ��  ");
		System.out.print("��Ȩ��תʱ�� \n");
		for (int i = 0; i < ab.length; i++) {
			if (ab[i].input_time > time) {
				time = ab[i].input_time;
			}

			System.out.print(ab[i].name + "\t  ");// ����ID
			System.out.print(ab[i].input_time + "\t    ");// ����ʱ��
			time += ab[i].Run_time;
			System.out.print(ab[i].Run_time + "\t    ");// ����ʱ��
			System.out.print(time + "\t   ");// ���ʱ��
			TimeSum[i] = (time - ab[i].input_time);
			System.out.print(TimeSum[i] + "\t   ");// ��תʱ��
			DTimeSum[i] = (double)(TimeSum[i] / ab[i].Run_time);
			
			System.out.print(DTimeSum[i]);// ��Ȩ��תʱ��
			System.out.println();
		}
		System.out.println("��ת��ʱ��:" + Arrays.stream(TimeSum).sum());
		System.out.println("ƽ����תʱ��:" + (double)Arrays.stream(TimeSum).sum()/ab.length);
		System.out.println("��Ȩ��ת��ʱ��:" + Arrays.stream(DTimeSum).sum());
		System.out.println("ƽ����Ȩ��תʱ��:" + Arrays.stream(DTimeSum).sum()/ab.length);
	}

	public static void runattribute(attribute[] ab) {// ���е���
		System.out.println("��ѡ������ʽ");
		Scanner in = new Scanner(System.in);
		int n = -1;
		while (n != 0) {
			System.out.println("1.�ȵ��ȷ���  2.��̽������� 3.ʱ��Ƭת�� 4.��ռʽ������Ȩ 0�˳�");
			n = in.nextInt();
			switch (n) {
			case 1:
				ab = InputTimesort(ab);
				OutputAttribute(ab);
				break;
			case 2:
				ab = Short_jobs_take_precedence(ab, 0, 0);
				OutputAttribute(ab);
				break;
			case 3:
				System.out.println("������ʱ��Ƭʱ��");
				n = in.nextInt();
				Time_slice_rotation(ab, n);
				break;
			case 4:
				ab = priorityTimesort(ab, 0, 0);
				OutputAttribute(ab);
				break;
			}
		}
		return;
	}

	// �ȵ��ȷ��񣬶�����ʱ������(ð������)
	private static attribute[] InputTimesort(attribute[] ab) {
		for (int i = 0; i < ab.length; i++) {
			int min = i;
			for (int J = i; J < ab.length; J++) {
				if (ab[J].getInput_time() < ab[i].getInput_time()) {
					min = J;
				}
			}
			swat(ab, i, min);
		}
		return ab;
	}
	
	//��̽�������
	private static attribute[] Short_jobs_take_precedence(attribute[] ab, int i, int Begin) {
		int min_Run_time = -1;
		int min_input_time = i;
		int index = -1;
		// ��ȡ����ʱ��֮ǰ������ʱ����̵�
		for (int j = Begin; j < ab.length; j++) {
			if (ab[j].input_time <= i) {
				if (min_Run_time == -1) {
					index = j;
					min_Run_time = ab[j].Run_time;
				} else {
					if (min_Run_time > ab[j].Run_time) {
						index = j;
						min_Run_time = ab[j].Run_time;
					}
				}
			}
		}
		if (index == -1) {
			min_Run_time = ab[Begin].Run_time;
			min_input_time = ab[Begin].input_time;
			index = Begin;
			for (int j = Begin; j < ab.length; j++) {
				if (ab[j].input_time < min_input_time) {
					min_input_time = ab[j].input_time;
					index = j;
					min_Run_time = ab[j].Run_time;
				} else {
					if (ab[j].input_time == min_input_time) {
						if (min_Run_time < ab[j].Run_time) {
							min_input_time = ab[j].input_time;
							index = j;
							min_Run_time = ab[j].Run_time;
						}
					}
				}
			}
		}
		swat(ab, Begin, index);
		if (Begin + 1 == ab.length) {
			return ab;
		}
		Short_jobs_take_precedence(ab, (min_input_time > i ? min_input_time : i) + min_Run_time, Begin + 1);
		return ab;
	}
	// ����λ��
	public static void swat(attribute[] ab, int i, int index) {
		attribute a = ab[i];
		ab[i] = ab[index];
		ab[index] = a;
	}

	//ʱ��Ƭת��
	private static attribute[] Time_slice_rotation(attribute[] ab, int n) {
		int[] Alltime = new int[ab.length];// �����Ҫʱ��
		for (int j = 0; j < ab.length; j++) {
			Alltime[j] = ab[j].Run_time;
		}
		int[] complete_Alltime = new int[ab.length];// �����ʱ��
		int min_input_time = -1;
		int index;
		int complete = 0;// ��ɸ���
		int N = 1;
		while (complete < ab.length) {
			index = -1;
			for (int i = 0; i < ab.length; i++) {
				if (ab[i].input_time >= N * n) {
					continue;
				}
				if (Alltime[i] <= complete_Alltime[i]) {
					continue;
				}
				if (index == -1) {
					index = i;
					min_input_time = ab[i].input_time;
				}
				if (ab[i].input_time < min_input_time) {
					index = i;
				}
			}
			if (index != -1) {
				if (ab[index].input_time > N * n - n) {
					complete_Alltime[index] = N * n - ab[index].input_time;
				} else {
					complete_Alltime[index] += n;
				}

				if (Alltime[index] <= complete_Alltime[index]) {
					complete++;
					complete_Alltime[index] = Alltime[index];
				}
				System.out.println("��" + N + "��ʱ��Ƭ ���н���" + ab[index].name + "����Ϊ " + complete_Alltime[index] + "/"
						+ Alltime[index]);
			} else {
				System.out.println("��" + N + "��ʱ��Ƭ ���޽��̽���");

			}
			N++;
		}
		return null;
	}
		
	// ��ռʽ������Ȩ
	private static attribute[] priorityTimesort(attribute[] ab, int i, int Begin) {
		int min_Run_time = -1;
		int min_input_time = i;
		int min_priority = 0;
		int index = -1;
		// ��ȡ����ʱ��֮ǰ�����ȼ���ߵ�
		for (int j = Begin; j < ab.length; j++) {
			if (ab[j].input_time <= min_input_time) {
				if (min_Run_time == -1) {
					index = j;
					min_Run_time = ab[j].Run_time;
					min_priority = (ab[j].input_time - i) / ab[j].Run_time;
				} else {
					if (min_priority > (ab[j].input_time - i) / ab[j].Run_time) {// ���ȼ����Ҵ�
						index = j;
						min_Run_time = ab[j].Run_time;
						min_priority = (ab[j].input_time - i) / ab[j].Run_time;
					}
				}
			}
		}
		if (index == -1) {
			min_Run_time = ab[Begin].Run_time;
			min_input_time = ab[Begin].input_time;
			index = Begin;
			for (int j = Begin; j < ab.length; j++) {
				if (ab[j].input_time < min_input_time) {// ����ʱ������֮ǰֱ�ӻ�
					min_input_time = ab[j].input_time;
					index = j;
					min_Run_time = ab[j].Run_time;
				} else {
					if (ab[j].input_time == min_input_time) {
						if (min_input_time < ab[j].Run_time) {// ����ʱ��Сֱ�ӻ�
							min_input_time = ab[j].input_time;
							index = j;
							min_Run_time = ab[j].Run_time;
						}
					}
				}
			}
		}
		swat(ab, Begin, index);
		if (Begin + 1 == ab.length) {
			return ab;
		}
		priorityTimesort(ab, (min_input_time > i ? min_input_time : i) + min_Run_time, Begin + 1);
		return ab;
	}
}

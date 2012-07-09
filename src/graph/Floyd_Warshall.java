package graph;
//���������㷨����㷨
//������ͼGΪ��ڣ��ó���������֮���·������dist[i][j]��·��path[i][j][k]��
//;�������ӵõ������0��ʾ��������Ҳ��0��ʾ
//O(V^3) V vetex E edge
//���������󴫵ݱհ� �����е�Ȩֵ��Ϊ1
//Ҳ�����ò�����ֵ ����հ�
//��ϸ����һ�¾����㷨�ظ�ƽ�� O(V^3*lnV)������ 
//һ�������ӱߣ���V�����棩Ȼ��ѭ��(V-1)��������Ϊ(V-1)��һ���Ǳ����� V������
//�����㷨�����ڲ��м�������ܱ��ܺõ��Ż�����Ϊ����˷��ڲ��м�������кܶ��Ż��취
public class Floyd_Warshall
{
	int[][]		dist	= null; // ��������֮��·������
	int[][][]	path	= null; // ��������֮���·��

	/**
	 * @param G
	 */
	public Floyd_Warshall(int[][] G)
	{
		int MAX = Integer.MAX_VALUE;
		int row = G.length;// ͼG������
		int[][] spot = new int[row][row];// ������������֮�侭���ĵ�
		int[] onePath = new int[row];// ��¼һ��·��
		dist = new int[row][row];
		path = new int[row][row][];
		for (int i = 0; i < row; i++)
			// ����ͼ����֮���·��
			for (int j = 0; j < row; j++) {
				if (G[i][j] == 0) {
					G[i][j] = MAX;// û��·����������֮���·��ΪĬ�����
				}
				if (i == j) {
					G[i][j] = 0;// ������·������Ϊ0
				}
			}
		for (int i = 0; i < row; i++) {
			// ��ʼ��Ϊ��������֮��û��·��
			for (int j = 0; j < row; j++) {
				spot[i][j] = -1;
			}
		}
		for (int i = 0; i < row; i++) {
			// ������������֮���û��·��
			onePath[i] = -1;
		}
		for (int v = 0; v < row; ++v) {
			for (int w = 0; w < row; ++w) {
				dist[v][w] = G[v][w];
			}
		}
		for (int u = 0; u < row; ++u) {
			for (int v = 0; v < row; ++v) {
				for (int w = 0; w < row; ++w) {
					// ��ֹ���
					if (dist[v][u] != MAX && dist[u][w] != MAX && dist[v][w] > dist[v][u] + dist[u][w]) {
						dist[v][w] = dist[v][u] + dist[u][w];// ������ڸ���·����ȡ����·��
						spot[v][w] = u;// �Ѿ����ĵ����
					}
				}
			}
		}

		/**
		 * �����Ǿ�����ʽ���ѿռ��O(V^3)��ʡ��O(V^2) int i, j, k; for (i = 1; i <= n; i++) {
		 * for (j = 1; j <= n; j++) { distance[i][j][0] = map[i][j]; } } for (k
		 * = 1; k <= n; k++) { for (i = 1; i <= n; i++) { for (j = 1; j <= n;
		 * j++) { distance[i][j][k] = distance[i][j][k - 1]; if
		 * (distance[i][k][k - 1] + distance[k][j][k - 1] < distance[i][j][k])
		 * distance[i][j][k] = distance[i][k][k - 1] + distance[k][j][k - 1]; }
		 * } }
		 */

		for (int i = 0; i < row; i++) {
			// ������е�·��
			int[] point = new int[1];
			for (int j = 0; j < row; j++) {
				point[0] = 0;
				onePath[point[0]++] = i;
				outputPath(spot, i, j, onePath, point);
				path[i][j] = new int[point[0]];
				for (int s = 0; s < point[0]; s++) {
					path[i][j][s] = onePath[s];
				}
			}
		}
	}

	void outputPath(int[][] spot, int i, int j, int[] onePath, int[] point)
	{
		// ���i ��j ��·����ʵ�ʴ��룬point[]��¼һ��·���ĳ���
		if (i == j) {
			return;
		}
		if (spot[i][j] == -1) {
			onePath[point[0]++] = j;
		}
		// System.out.print(" "+j+" ");
		else {
			outputPath(spot, i, spot[i][j], onePath, point);
			outputPath(spot, spot[i][j], j, onePath, point);
		}
	}

	public static void main(String[] args)
	{
		int data[][] = { { 0, 27, 44, 17, 11, 27, 42, 0, 0, 0, 20, 25, 21, 21, 18, 27, 0 },// x1
				{ 27, 0, 31, 27, 49, 0, 0, 0, 0, 0, 0, 0, 52, 21, 41, 0, 0 },// 1
				{ 44, 31, 0, 19, 0, 27, 32, 0, 0, 0, 47, 0, 0, 0, 32, 0, 0 },// 2
				{ 17, 27, 19, 0, 14, 0, 0, 0, 0, 0, 30, 0, 0, 0, 31, 0, 0 },// 3
				{ 11, 49, 0, 14, 0, 13, 20, 0, 0, 28, 15, 0, 0, 0, 15, 25, 30 },// 4
				{ 27, 0, 27, 0, 13, 0, 9, 21, 0, 26, 26, 0, 0, 0, 28, 29, 0 },// 5
				{ 42, 0, 32, 0, 20, 9, 0, 13, 0, 32, 0, 0, 0, 0, 0, 33, 0 },// 6
				{ 0, 0, 0, 0, 0, 21, 13, 0, 19, 0, 0, 0, 0, 0, 0, 0, 0 },// 7
				{ 0, 0, 0, 0, 0, 0, 0, 19, 0, 11, 20, 0, 0, 0, 0, 33, 21 },// 8
				{ 0, 0, 0, 0, 28, 26, 32, 0, 11, 0, 10, 20, 0, 0, 29, 14, 13 },// 9
				{ 20, 0, 47, 30, 15, 26, 0, 0, 20, 10, 0, 18, 0, 0, 14, 9, 20 },// 10
				{ 25, 0, 0, 0, 0, 0, 0, 0, 0, 20, 18, 0, 23, 0, 0, 14, 0 },// 11
				{ 21, 52, 0, 0, 0, 0, 0, 0, 0, 0, 0, 23, 0, 27, 22, 0, 0 },// 12
				{ 21, 21, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 27, 0, 0, 0, 0 },// 13
				{ 18, 41, 32, 31, 15, 28, 0, 0, 0, 29, 14, 0, 22, 0, 0, 11, 0 },// 14
				{ 27, 0, 0, 0, 25, 29, 33, 0, 33, 14, 9, 14, 0, 0, 11, 0, 9 },// 15
				{ 0, 0, 0, 0, 30, 0, 0, 0, 21, 13, 20, 0, 0, 0, 0, 9, 0 } // 16
		};
		for (int i = 0; i < data.length; i++) {
			for (int j = i; j < data.length; j++) {
				if (data[i][j] != data[j][i]) {
					return;
				}
			}
		}
		Floyd_Warshall test = new Floyd_Warshall(data);
		for (int i = 0; i < data.length; i++) {
			for (int j = i; j < data[i].length; j++) {
				System.out.println();
				System.out.print("From " + i + " to " + j + " path is: ");
				for (int k = 0; k < test.path[i][j].length; k++) {
					System.out.print(test.path[i][j][k] + " ");
				}
				System.out.println();
				System.out.println("From " + i + " to " + j + " length :" + test.dist[i][j]);
			}
		}
	}
}
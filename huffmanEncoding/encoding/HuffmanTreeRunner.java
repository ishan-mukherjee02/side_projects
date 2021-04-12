package huffman.encoding;

import java.util.PriorityQueue;

public class HuffmanTreeRunner {

	public static void main(String[] args) {
		PriorityQueue<FrequencyTreeNode> pq = new PriorityQueue<FrequencyTreeNode>();
		
		pq.add(new FrequencyTreeNode('d', 3));
		pq.add(new FrequencyTreeNode('a', 2));
		pq.add(new FrequencyTreeNode('q', 4));
		pq.add(new FrequencyTreeNode('b', 1));
		
		HuffmanTree h1 = new HuffmanTree(pq);

		System.out.println("Test");
		
	}

}

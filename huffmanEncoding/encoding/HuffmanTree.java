package huffman.encoding;

import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

public class HuffmanTree
{
    private FrequencyTreeNode root;
    
    public HuffmanTree(PriorityQueue<FrequencyTreeNode> pq)
    {
    	while(pq.size() > 1)
    	{
    		FrequencyTreeNode temp = new FrequencyTreeNode('-',  0);
    		
    		temp.left = pq.poll();
    		temp.right = pq.poll();

    		temp.frequency = temp.left.frequency + temp.right.frequency;
    		
    		pq.add(temp);
    	}
    	root = pq.poll();
    }
//    
//    public String encodeLetter(char letter)
//    {
//        FrequencyTreeNode temp = root;
//        
//        while(temp.letter != letter)
//        {
//        	
//        }
//    }
//    
//    private String encodeLetter(char letter, FrequencyTreeNode root)
//    {
//        
//    }
//    
//    // returns a map of characters to encodings
//    public Map<Character, String> encodingScheme()
//    {
//        
//    }
    
    private void encodingScheme(FrequencyTreeNode root, String route, Map<Character, String> scheme)
    {
        
    }
}

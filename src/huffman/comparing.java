package huffman;

import java.util.Comparator;

public class comparing implements Comparator<HNode> {
    @Override
    public int compare(HNode x,HNode y)
    {
        return (x.data - y.data);
    }
}

package storage;

public class IntArrayBag
{
    private int[] data;
    private int manyItems;

    public IntArrayBag()
    {
        data = new int[10];
        manyItems = 0;
    }

    public void add(int data)
    {
        if (manyItems == this.data.length)
        {
            ensureCapacity(this.data.length * 2 + 1);
        }
        this.data[manyItems++] = data;
    }

    public void addMany(int... elements)
    {
        if (manyItems + elements.length > this.data.length)
        {
            ensureCapacity(this.data.length + elements.length * 2 + 1);
        }
        System.arraycopy(elements, 0, data, manyItems, elements.length);
        manyItems += elements.length;
    }

    public int countOccurances(int target)
    {
        int answer = 0;
        for (int i = 0; i < manyItems; i++)
        {
            if (data[i] == target)
            {
                answer++;
            }
        }
        return answer;
    }

    public int getCapacity()
    {
        return data.length;
    }

    public int getSize()
    {
        return manyItems;
    }

    public void ensureCapacity(int minimumCapacity )
    {
        if (minimumCapacity > data.length)
        {
            int[] biggerArray = new int[minimumCapacity];
            System.arraycopy(data, 0, biggerArray, 0, manyItems);
            this.data = biggerArray;
        }
    }

    public IntArrayBag clone()
    {
        IntArrayBag answer;
        try
        {
            answer = (IntArrayBag) super.clone();
        }
        catch (CloneNotSupportedException e)
        {
            throw new RuntimeException("Clone not supported");
        }
        answer.data = this.data.clone();
        return answer;
    }
}
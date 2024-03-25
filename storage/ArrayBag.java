package storage;

public class ArrayBag<T>
{
    public static final int DEFAULT_CAPACITY = 10;
    private Object[] data;
    private int manyItems;

    public ArrayBag()
    {
        data = new Object[DEFAULT_CAPACITY];
        manyItems = 0;
    }

    public void add(T data)
    {
        if (manyItems == this.data.length)
        {
            ensureCapacity(this.data.length * 2 + 1);
        }
        this.data[manyItems++] = data;
    }

    @SafeVarargs
    public final void addMany(T... elements)
    {
        if (manyItems + elements.length > this.data.length)
        {
            ensureCapacity(this.data.length + elements.length * 2 + 1);
        }
        System.arraycopy(elements, 0, data, manyItems, elements.length);
        manyItems += elements.length;
    }

    public int countOccurances(T target)
    {
        int answer = 0;
        for (int i = 0; i < manyItems; i++)
        {
            if (data[i].equals(target))
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
            Object[] biggerArray = new Object[minimumCapacity];
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
public class Test
{

    public static final double PI = 3.14159265358979323846;
    private static int sharedValue;
    private int localValue;

    public void setValues(int iValue)
    {
        Test.sharedValue = iValue;
        localValue = iValue;
    }

    public int getSharedValue()
    {
        return Test.sharedValue;
    }
    public int getLocalValue()
    {
        return localValue;
    }
}


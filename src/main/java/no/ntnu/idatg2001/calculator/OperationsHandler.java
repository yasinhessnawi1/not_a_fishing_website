package no.ntnu.idatg2001.calculator;

import java.util.HashMap;
import java.util.Map;

public class OperationsHandler
{
    private Map<Integer, Operations> listOfOperations;

    public OperationsHandler()
    {
        listOfOperations = new HashMap<> ();
        for (Operations operations: listOfOperations.values ())
        {
            listOfOperations.put ( operations.ordinal (), operations );
        }
    }

    public Operations getOperation(int ordinal)
    {

        Operations operations = listOfOperations.get ( ordinal );

        if (ordinal > 0 && ordinal <= listOfOperations.size ())
        {
           return operations;
        } else
        {
            return Operations.UNKNOWN;
        }

    }


}

package no.ntnu.idatg2001.calculator;

public enum Operations
{
    UNKNOWN (""),PLUS ( "+" ), MINUS ( "-" ), EQUAL ( "=" ), MULTIPLY ( "X" ), DIVIDE ( "/" ), CLEAR ( "C" ),
    INFO ( "?" );

    String operation;

    Operations ( String operation )
    {
        this.operation = operation;
    }

}

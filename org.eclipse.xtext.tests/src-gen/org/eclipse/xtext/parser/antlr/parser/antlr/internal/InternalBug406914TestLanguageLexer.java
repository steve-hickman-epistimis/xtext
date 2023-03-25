package org.eclipse.xtext.parser.antlr.parser.antlr.internal;

// Hack: Use our own Lexer superclass by means of import. 
// Currently there is no other way to specify the superclass for the lexer.
import org.eclipse.xtext.parser.antlr.Lexer;


import org.antlr.runtime.*;
import java.util.Stack;
import java.util.List;
import java.util.ArrayList;

@SuppressWarnings("all")
public class InternalBug406914TestLanguageLexer extends Lexer {
    public static final int T__9=9;
    public static final int T__8=8;
    public static final int T__7=7;
    public static final int RULE_ID=4;
    public static final int RULE_WS=5;
    public static final int RULE_ANY_OTHER=6;
    public static final int T__11=11;
    public static final int T__12=12;
    public static final int T__13=13;
    public static final int EOF=-1;
    public static final int T__10=10;

    // delegates
    // delegators

    public InternalBug406914TestLanguageLexer() {;} 
    public InternalBug406914TestLanguageLexer(CharStream input) {
        this(input, new RecognizerSharedState());
    }
    public InternalBug406914TestLanguageLexer(CharStream input, RecognizerSharedState state) {
        super(input,state);

    }
    public String getGrammarFileName() { return "InternalBug406914TestLanguage.g"; }

    // $ANTLR start "T__7"
    public final void mT__7() throws RecognitionException {
        try {
            int _type = T__7;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // InternalBug406914TestLanguage.g:11:6: ( '\\b' )
            // InternalBug406914TestLanguage.g:11:8: '\\b'
            {
            match('\b'); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__7"

    // $ANTLR start "T__8"
    public final void mT__8() throws RecognitionException {
        try {
            int _type = T__8;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // InternalBug406914TestLanguage.g:12:6: ( '\\f' )
            // InternalBug406914TestLanguage.g:12:8: '\\f'
            {
            match('\f'); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__8"

    // $ANTLR start "T__9"
    public final void mT__9() throws RecognitionException {
        try {
            int _type = T__9;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // InternalBug406914TestLanguage.g:13:6: ( '\\n' )
            // InternalBug406914TestLanguage.g:13:8: '\\n'
            {
            match('\n'); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__9"

    // $ANTLR start "T__10"
    public final void mT__10() throws RecognitionException {
        try {
            int _type = T__10;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // InternalBug406914TestLanguage.g:14:7: ( 'lineFeed' )
            // InternalBug406914TestLanguage.g:14:9: 'lineFeed'
            {
            match("lineFeed"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__10"

    // $ANTLR start "T__11"
    public final void mT__11() throws RecognitionException {
        try {
            int _type = T__11;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // InternalBug406914TestLanguage.g:15:7: ( '\\r' )
            // InternalBug406914TestLanguage.g:15:9: '\\r'
            {
            match('\r'); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__11"

    // $ANTLR start "T__12"
    public final void mT__12() throws RecognitionException {
        try {
            int _type = T__12;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // InternalBug406914TestLanguage.g:16:7: ( '\\t' )
            // InternalBug406914TestLanguage.g:16:9: '\\t'
            {
            match('\t'); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__12"

    // $ANTLR start "T__13"
    public final void mT__13() throws RecognitionException {
        try {
            int _type = T__13;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // InternalBug406914TestLanguage.g:17:7: ( '\\\\' )
            // InternalBug406914TestLanguage.g:17:9: '\\\\'
            {
            match('\\'); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__13"

    // $ANTLR start "RULE_ID"
    public final void mRULE_ID() throws RecognitionException {
        try {
            int _type = RULE_ID;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // InternalBug406914TestLanguage.g:172:9: ( ( '^' )? ( 'a' .. 'z' | 'A' .. 'Z' | '_' ) ( 'a' .. 'z' | 'A' .. 'Z' | '_' | '0' .. '9' )* )
            // InternalBug406914TestLanguage.g:172:11: ( '^' )? ( 'a' .. 'z' | 'A' .. 'Z' | '_' ) ( 'a' .. 'z' | 'A' .. 'Z' | '_' | '0' .. '9' )*
            {
            // InternalBug406914TestLanguage.g:172:11: ( '^' )?
            int alt1=2;
            int LA1_0 = input.LA(1);

            if ( (LA1_0=='^') ) {
                alt1=1;
            }
            switch (alt1) {
                case 1 :
                    // InternalBug406914TestLanguage.g:172:11: '^'
                    {
                    match('^'); 

                    }
                    break;

            }

            if ( (input.LA(1)>='A' && input.LA(1)<='Z')||input.LA(1)=='_'||(input.LA(1)>='a' && input.LA(1)<='z') ) {
                input.consume();

            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;}

            // InternalBug406914TestLanguage.g:172:40: ( 'a' .. 'z' | 'A' .. 'Z' | '_' | '0' .. '9' )*
            loop2:
            do {
                int alt2=2;
                int LA2_0 = input.LA(1);

                if ( ((LA2_0>='0' && LA2_0<='9')||(LA2_0>='A' && LA2_0<='Z')||LA2_0=='_'||(LA2_0>='a' && LA2_0<='z')) ) {
                    alt2=1;
                }


                switch (alt2) {
            	case 1 :
            	    // InternalBug406914TestLanguage.g:
            	    {
            	    if ( (input.LA(1)>='0' && input.LA(1)<='9')||(input.LA(1)>='A' && input.LA(1)<='Z')||input.LA(1)=='_'||(input.LA(1)>='a' && input.LA(1)<='z') ) {
            	        input.consume();

            	    }
            	    else {
            	        MismatchedSetException mse = new MismatchedSetException(null,input);
            	        recover(mse);
            	        throw mse;}


            	    }
            	    break;

            	default :
            	    break loop2;
                }
            } while (true);


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "RULE_ID"

    // $ANTLR start "RULE_WS"
    public final void mRULE_WS() throws RecognitionException {
        try {
            int _type = RULE_WS;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // InternalBug406914TestLanguage.g:174:9: ( ( ' ' | '\\t' )+ )
            // InternalBug406914TestLanguage.g:174:11: ( ' ' | '\\t' )+
            {
            // InternalBug406914TestLanguage.g:174:11: ( ' ' | '\\t' )+
            int cnt3=0;
            loop3:
            do {
                int alt3=2;
                int LA3_0 = input.LA(1);

                if ( (LA3_0=='\t'||LA3_0==' ') ) {
                    alt3=1;
                }


                switch (alt3) {
            	case 1 :
            	    // InternalBug406914TestLanguage.g:
            	    {
            	    if ( input.LA(1)=='\t'||input.LA(1)==' ' ) {
            	        input.consume();

            	    }
            	    else {
            	        MismatchedSetException mse = new MismatchedSetException(null,input);
            	        recover(mse);
            	        throw mse;}


            	    }
            	    break;

            	default :
            	    if ( cnt3 >= 1 ) break loop3;
                        EarlyExitException eee =
                            new EarlyExitException(3, input);
                        throw eee;
                }
                cnt3++;
            } while (true);


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "RULE_WS"

    // $ANTLR start "RULE_ANY_OTHER"
    public final void mRULE_ANY_OTHER() throws RecognitionException {
        try {
            int _type = RULE_ANY_OTHER;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // InternalBug406914TestLanguage.g:176:16: ( . )
            // InternalBug406914TestLanguage.g:176:18: .
            {
            matchAny(); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "RULE_ANY_OTHER"

    public void mTokens() throws RecognitionException {
        // InternalBug406914TestLanguage.g:1:8: ( T__7 | T__8 | T__9 | T__10 | T__11 | T__12 | T__13 | RULE_ID | RULE_WS | RULE_ANY_OTHER )
        int alt4=10;
        alt4 = dfa4.predict(input);
        switch (alt4) {
            case 1 :
                // InternalBug406914TestLanguage.g:1:10: T__7
                {
                mT__7(); 

                }
                break;
            case 2 :
                // InternalBug406914TestLanguage.g:1:15: T__8
                {
                mT__8(); 

                }
                break;
            case 3 :
                // InternalBug406914TestLanguage.g:1:20: T__9
                {
                mT__9(); 

                }
                break;
            case 4 :
                // InternalBug406914TestLanguage.g:1:25: T__10
                {
                mT__10(); 

                }
                break;
            case 5 :
                // InternalBug406914TestLanguage.g:1:31: T__11
                {
                mT__11(); 

                }
                break;
            case 6 :
                // InternalBug406914TestLanguage.g:1:37: T__12
                {
                mT__12(); 

                }
                break;
            case 7 :
                // InternalBug406914TestLanguage.g:1:43: T__13
                {
                mT__13(); 

                }
                break;
            case 8 :
                // InternalBug406914TestLanguage.g:1:49: RULE_ID
                {
                mRULE_ID(); 

                }
                break;
            case 9 :
                // InternalBug406914TestLanguage.g:1:57: RULE_WS
                {
                mRULE_WS(); 

                }
                break;
            case 10 :
                // InternalBug406914TestLanguage.g:1:65: RULE_ANY_OTHER
                {
                mRULE_ANY_OTHER(); 

                }
                break;

        }

    }


    protected DFA4 dfa4 = new DFA4(this);
    static final String DFA4_eotS =
        "\4\uffff\1\20\1\uffff\1\22\1\uffff\1\13\6\uffff\1\20\5\uffff\5\20\1\33\1\uffff";
    static final String DFA4_eofS =
        "\34\uffff";
    static final String DFA4_minS =
        "\1\0\3\uffff\1\151\1\uffff\1\11\1\uffff\1\101\6\uffff\1\156\5\uffff\1\145\1\106\2\145\1\144\1\60\1\uffff";
    static final String DFA4_maxS =
        "\1\uffff\3\uffff\1\151\1\uffff\1\40\1\uffff\1\172\6\uffff\1\156\5\uffff\1\145\1\106\2\145\1\144\1\172\1\uffff";
    static final String DFA4_acceptS =
        "\1\uffff\1\1\1\2\1\3\1\uffff\1\5\1\uffff\1\7\1\uffff\1\10\1\11\1\12\1\1\1\2\1\3\1\uffff\1\10\1\5\1\6\1\11\1\7\6\uffff\1\4";
    static final String DFA4_specialS =
        "\1\0\33\uffff}>";
    static final String[] DFA4_transitionS = DFA4_transitionS_.DFA4_transitionS;
    private static final class DFA4_transitionS_ {
        static final String[] DFA4_transitionS = {
                "\10\13\1\1\1\6\1\3\1\13\1\2\1\5\22\13\1\12\40\13\32\11\1\13\1\7\1\13\1\10\1\11\1\13\13\11\1\4\16\11\uff85\13",
                "",
                "",
                "",
                "\1\17",
                "",
                "\1\23\26\uffff\1\23",
                "",
                "\32\20\4\uffff\1\20\1\uffff\32\20",
                "",
                "",
                "",
                "",
                "",
                "",
                "\1\25",
                "",
                "",
                "",
                "",
                "",
                "\1\26",
                "\1\27",
                "\1\30",
                "\1\31",
                "\1\32",
                "\12\20\7\uffff\32\20\4\uffff\1\20\1\uffff\32\20",
                ""
        };
    }

    static final short[] DFA4_eot = DFA.unpackEncodedString(DFA4_eotS);
    static final short[] DFA4_eof = DFA.unpackEncodedString(DFA4_eofS);
    static final char[] DFA4_min = DFA.unpackEncodedStringToUnsignedChars(DFA4_minS);
    static final char[] DFA4_max = DFA.unpackEncodedStringToUnsignedChars(DFA4_maxS);
    static final short[] DFA4_accept = DFA.unpackEncodedString(DFA4_acceptS);
    static final short[] DFA4_special = DFA.unpackEncodedString(DFA4_specialS);
    static final short[][] DFA4_transition;

    static {
        int numStates = DFA4_transitionS.length;
        DFA4_transition = new short[numStates][];
        for (int i=0; i<numStates; i++) {
            DFA4_transition[i] = DFA.unpackEncodedString(DFA4_transitionS[i]);
        }
    }

    static class DFA4 extends DFA {

        public DFA4(BaseRecognizer recognizer) {
            this.recognizer = recognizer;
            this.decisionNumber = 4;
            this.eot = DFA4_eot;
            this.eof = DFA4_eof;
            this.min = DFA4_min;
            this.max = DFA4_max;
            this.accept = DFA4_accept;
            this.special = DFA4_special;
            this.transition = DFA4_transition;
        }
        public String getDescription() {
            return "1:1: Tokens : ( T__7 | T__8 | T__9 | T__10 | T__11 | T__12 | T__13 | RULE_ID | RULE_WS | RULE_ANY_OTHER );";
        }
        public int specialStateTransition(int s, IntStream _input) throws NoViableAltException {
            IntStream input = _input;
        	int _s = s;
            switch ( s ) {
                    case 0 : 
                        int LA4_0 = input.LA(1);

                        s = -1;
                        if ( (LA4_0=='\b') ) {s = 1;}

                        else if ( (LA4_0=='\f') ) {s = 2;}

                        else if ( (LA4_0=='\n') ) {s = 3;}

                        else if ( (LA4_0=='l') ) {s = 4;}

                        else if ( (LA4_0=='\r') ) {s = 5;}

                        else if ( (LA4_0=='\t') ) {s = 6;}

                        else if ( (LA4_0=='\\') ) {s = 7;}

                        else if ( (LA4_0=='^') ) {s = 8;}

                        else if ( ((LA4_0>='A' && LA4_0<='Z')||LA4_0=='_'||(LA4_0>='a' && LA4_0<='k')||(LA4_0>='m' && LA4_0<='z')) ) {s = 9;}

                        else if ( (LA4_0==' ') ) {s = 10;}

                        else if ( ((LA4_0>='\u0000' && LA4_0<='\u0007')||LA4_0=='\u000B'||(LA4_0>='\u000E' && LA4_0<='\u001F')||(LA4_0>='!' && LA4_0<='@')||LA4_0=='['||LA4_0==']'||LA4_0=='`'||(LA4_0>='{' && LA4_0<='\uFFFF')) ) {s = 11;}

                        if ( s>=0 ) return s;
                        break;
            }
            NoViableAltException nvae =
                new NoViableAltException(getDescription(), 4, _s, input);
            error(nvae);
            throw nvae;
        }
    }
 

}
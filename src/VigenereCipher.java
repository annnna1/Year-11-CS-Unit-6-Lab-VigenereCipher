public class VigenereCipher
{
    private String key;
    private String alphabet;

    public VigenereCipher(String key) {
        alphabet = "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ";
        this.key = key.toLowerCase();
    }
    public String getKey()
    {
        return key;
    }
    public void setKey(String k)
    {
        key = k.toLowerCase();
    }
    public String getAlphabet()
    {
        return alphabet;
    }
    public String encode (String x)
    {
        String encodedMessage = "";

        for(int i = 0 ; i < x.length() ; i ++)
        {
            char enc = x.charAt((i));
            int ind = alphabet.indexOf(enc);
            if(!(ind==-1))
            {
                if(ind>=26)
                {
                    enc += 32;
                }
                enc = (char)((enc + key.charAt(i%key.length()) - (2 * 'a')) % 26 + 'a' );
            }
            encodedMessage+=enc;
        }
        return encodedMessage;
    }
    public String decode (String x)
    {
        String decodedMessage = "";
        for(int i = 0 ; i < x.length() ; i ++)
        {
            char dec = x.charAt((i));
            int ind = alphabet.indexOf(dec);;
            if(!(ind==-1))
            {
                if(ind>=26)
                {
                    dec += 32;
                }
                dec = (char)((dec - key.charAt(i%key.length()) + 26 ) % 26 + 'a' );
            }
            decodedMessage += dec;
        }
        return decodedMessage;
    }
}

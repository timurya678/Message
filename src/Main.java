import java.util.regex.*;

interface IMessage {


    public int countWords();        // возвращает количество слов
    public String reverse();
    public int count(char c);
    public int countRegex(char c);
}

class Message implements IMessage {
    private String message;

    public Message(String message) {
        this.message = message;
    }

    // реализовать все методы интерфейса IMessage...

    public int countWords() {
        return message.trim().split("\\s+").length;
    }

    public String reverse() {
        return new StringBuilder(message).reverse().toString();
    }

    public int count(char c) {
        int count = 0;
        for (int i = 0; i < message.length(); i++) {
            if (message.charAt(i)==c)
                count++;
        }
        return count;
    }

    public int countRegex (char c) {
        Pattern pattern = Pattern.compile(Character.toString(c));
        Matcher matcher = pattern.matcher(message);
        int count = 0;
        while (matcher.find()) {
            count++;
        }
        return count;
    }


}


public class Main {
    public static void main(String[] args) {
        Message msg = new Message("s  Test, 123  message?  s");
        System.out.println(msg.countWords());
        System.out.println(msg.reverse());
        System.out.println(msg.count('e'));
        System.out.println(msg.countRegex('s'));
    }
}

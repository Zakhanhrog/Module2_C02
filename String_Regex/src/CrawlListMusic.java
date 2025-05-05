import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URL;
import java.net.URLConnection;
import java.nio.charset.StandardCharsets;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class CrawlListMusic {

    private static String decodeHtmlEntities(String text) {

        text = text.replaceAll("à", "à"); text = text.replaceAll("À", "À");
        text = text.replaceAll("á", "á"); text = text.replaceAll("Á", "Á");
        text = text.replaceAll("â", "â"); text = text.replaceAll("Â", "Â");
        text = text.replaceAll("ã", "ã"); text = text.replaceAll("Ã", "Ã");
        text = text.replaceAll("è", "è"); text = text.replaceAll("È", "È");
        text = text.replaceAll("é", "é"); text = text.replaceAll("É", "É");
        text = text.replaceAll("ê", "ê"); text = text.replaceAll("Ê", "Ê");
        text = text.replaceAll("ì", "ì"); text = text.replaceAll("Ì", "Ì");
        text = text.replaceAll("í", "í"); text = text.replaceAll("Í", "Í");
        text = text.replaceAll("ò", "ò"); text = text.replaceAll("Ò", "Ò");
        text = text.replaceAll("ó", "ó"); text = text.replaceAll("Ó", "Ó");
        text = text.replaceAll("ô", "ô"); text = text.replaceAll("Ô", "Ô");
        text = text.replaceAll("õ", "õ"); text = text.replaceAll("Õ", "Õ");
        text = text.replaceAll("ù", "ù"); text = text.replaceAll("Ù", "Ù");
        text = text.replaceAll("ú", "ú"); text = text.replaceAll("Ú", "Ú");
        text = text.replaceAll("ý", "ý"); text = text.replaceAll("Ý", "Ý");

        text = text.replaceAll("&đ;", "đ"); text = text.replaceAll("&Đ;", "Đ");
        text = text.replaceAll("&ả;", "ả"); text = text.replaceAll("&Ả;", "Ả");
        text = text.replaceAll("&ẩ;", "ẩ"); text = text.replaceAll("&Ẩ;", "Ẩ");
        text = text.replaceAll("&ẳ;", "ẳ"); text = text.replaceAll("&Ẳ;", "Ẳ");
        text = text.replaceAll("&ẻ;", "ẻ"); text = text.replaceAll("&Ẻ;", "Ẻ");
        text = text.replaceAll("&ể;", "ể"); text = text.replaceAll("&Ể;", "Ể");
        text = text.replaceAll("&ỉ;", "ỉ"); text = text.replaceAll("&Ỉ;", "Ỉ");
        text = text.replaceAll("&ỏ;", "ỏ"); text = text.replaceAll("&Ỏ;", "Ỏ");
        text = text.replaceAll("&ổ;", "ổ"); text = text.replaceAll("&Ổ;", "Ổ");
        text = text.replaceAll("&ở;", "ở"); text = text.replaceAll("&Ở;", "Ở");
        text = text.replaceAll("&ủ;", "ủ"); text = text.replaceAll("&Ủ;", "Ủ");
        text = text.replaceAll("&ử;", "ử"); text = text.replaceAll("&Ử;", "Ử");
        text = text.replaceAll("&ỷ;", "ỷ"); text = text.replaceAll("&Ỷ;", "Ỷ");
        text = text.replaceAll("&ạ;", "ạ"); text = text.replaceAll("&Ạ;", "Ạ");
        text = text.replaceAll("&ậ;", "ậ"); text = text.replaceAll("&Ậ;", "Ậ");
        text = text.replaceAll("&ặ;", "ặ"); text = text.replaceAll("&Ặ;", "Ặ");
        text = text.replaceAll("&ẹ;", "ẹ"); text = text.replaceAll("&Ẹ;", "Ẹ");
        text = text.replaceAll("&ệ;", "ệ"); text = text.replaceAll("&Ệ;", "Ệ");
        text = text.replaceAll("&ị;", "ị"); text = text.replaceAll("&Ị;", "Ị");
        text = text.replaceAll("&ọ;", "ọ"); text = text.replaceAll("&Ọ;", "Ọ");
        text = text.replaceAll("&ộ;", "ộ"); text = text.replaceAll("&Ộ;", "Ộ");
        text = text.replaceAll("&ợ;", "ợ"); text = text.replaceAll("&Ợ;", "Ợ");
        text = text.replaceAll("&ụ;", "ụ"); text = text.replaceAll("&Ụ;", "Ụ");
        text = text.replaceAll("&ự;", "ự"); text = text.replaceAll("&Ự;", "Ự");
        text = text.replaceAll("&ỵ;", "ỵ"); text = text.replaceAll("&Y;", "Ỵ");

        text = text.replaceAll("&ơ", "ơ"); text = text.replaceAll("&Ơ", "Ơ");
        text = text.replaceAll("&ư", "ư"); text = text.replaceAll("&Ư", "Ư");
        text = text.replaceAll("&ừ", "ừ"); text = text.replaceAll("&Ừ", "Ừ");
        text = text.replaceAll("&ứ", "ứ"); text = text.replaceAll("&Ứ", "Ứ");
        text = text.replaceAll("&ừ", "ừ"); text = text.replaceAll("&Ừ", "Ừ");
        text = text.replaceAll("&ữ", "ữ"); text = text.replaceAll("&Ữ", "Ữ");
        text = text.replaceAll("&ờ", "ờ"); text = text.replaceAll("&Ờ", "Ờ");
        text = text.replaceAll("&ớ", "ớ"); text = text.replaceAll("&Ớ", "Ớ");
        text = text.replaceAll("&ỡ", "ỡ"); text = text.replaceAll("&Ỡ", "Ỡ");
        text = text.replaceAll("&", "&");
        return text;
    }

    private static String getFormattedLyrics(String html, String regex) {
        Pattern p = Pattern.compile(regex, Pattern.DOTALL);
        Matcher m = p.matcher(html);
        if (m.find()) {
            String rawLyrics = m.group(1);
            String withNewlines = rawLyrics.replaceAll("(?i)<br\\s*/?>", "\n");
            String noTags = withNewlines.replaceAll("<[^>]+>", "");
            String decodedLyrics = decodeHtmlEntities(noTags);
            return decodedLyrics.trim();
        }
        return null;
    }

    public static void main(String[] args) {
        String urlString = "https://www.nhaccuatui.com/bai-hat/hen-gap-em-duoi-anh-trang-manbo-ft-hieuthuhai-ft-hurrykng.IoXc9HUAwPSg.html";
        try {
            URL url = new URL(urlString);
            URLConnection connection = url.openConnection();
            connection.setRequestProperty("User-Agent", "Mozilla/5.0");
            try (Scanner scanner = new Scanner(new InputStreamReader(connection.getInputStream(), StandardCharsets.UTF_8))) {
                scanner.useDelimiter("\\A");
                String content = scanner.hasNext() ? scanner.next() : "";

                String lyrics = getFormattedLyrics(content, "<p[^>]*class=['\"]pd_lyric trans['\"][^>]*>(.*?)</p>");
                if (lyrics == null || lyrics.isEmpty()) {
                    lyrics = getFormattedLyrics(content, "<p[^>]*id=['\"]divLyric['\"][^>]*>(.*?)</p>");
                }

                if (lyrics != null && !lyrics.isEmpty()) {
                    System.out.println(lyrics);
                } else {
                    System.out.println("Không tìm thấy lời bài hát.");
                }
            }
        } catch (IOException e) {
            System.err.println("Lỗi xảy ra khi kết nối hoặc đọc dữ liệu: " + e.getMessage());
        } catch (Exception e) {
            System.err.println("Lỗi không xác định: " + e.getMessage());
            e.printStackTrace();
        }
    }
}
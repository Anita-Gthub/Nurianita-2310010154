/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Latihan;
import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.function.Supplier;
import javax.swing.JTextArea;

public class PenghitungUmurHelper {

    public String hitungUmurDetail(LocalDate lahir, LocalDate sekarang) {
        long tahun = ChronoUnit.YEARS.between(lahir, sekarang);
        long bulan = ChronoUnit.MONTHS.between(lahir.plusYears(tahun), sekarang);
        long hari = ChronoUnit.DAYS.between(lahir.plusYears(tahun).plusMonths(bulan), sekarang);
        return tahun + " Tahun, " + bulan + " Bulan, " + hari + " Hari";
    }

    public LocalDate hariUlangTahunBerikutnya(LocalDate lahir, LocalDate sekarang) {
        LocalDate ulangTahun = lahir.withYear(sekarang.getYear());
        return ulangTahun.isBefore(sekarang) ? ulangTahun.plusYears(1) : ulangTahun;
    }

    public String getDayOfWeekInIndonesian(LocalDate date) {
        switch (date.getDayOfWeek()) {
            case MONDAY: return "Senin";
            case TUESDAY: return "Selasa";
            case WEDNESDAY: return "Rabu";
            case THURSDAY: return "Kamis";
            case FRIDAY: return "Jumat";
            case SATURDAY: return "Sabtu";
            case SUNDAY: return "Minggu";
            default: return "Tidak diketahui";
        }
    }

    public void getPeristiwaBarisPerBaris(LocalDate date, JTextArea textArea, Supplier<Boolean> stopFlag) {
        String[] peristiwa = {
            "1900 - Penemuan besar di ilmu pengetahuan",
            "1945 - Hari Proklamasi Indonesia",
            "1969 - Pendaratan manusia di bulan",
            "2000 - Milenium baru dimulai",
            "2020 - Pandemi COVID-19"
        };
        for (String peristiwaItem : peristiwa) {
            if (stopFlag.get()) return;
            try {
                Thread.sleep(1000); // Simulasi pemrosesan
                javax.swing.SwingUtilities.invokeLater(() -> textArea.append(peristiwaItem + "\n"));
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
                return;
            }
        }
    }
}


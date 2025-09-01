package boot.start.domain;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;

@Getter
@Setter
@NoArgsConstructor
public class Book {
    private Long id;
    private String title;
    private String publisher;
    private double salePrice;
    private double rentalPrice;
    private String renter;
    private LocalDate registrationDate;
    private LocalDate updateDate;

    @Override
    public String toString() {
        return "Book{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", publisher='" + publisher + '\'' +
                ", salePrice=" + salePrice +
                ", rentalPrice=" + rentalPrice +
                ", renter='" + renter + '\'' +
                ", registrationDate=" + registrationDate +
                ", updateDate=" + updateDate +
                '}';
    }
}

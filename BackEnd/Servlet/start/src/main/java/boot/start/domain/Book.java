package boot.start.domain;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Book {
    private Long id;
    private String title;
    private String publisher;
    private double salePrice;
    private double rentalPrice;
    private String renter;
    private LocalDate registrationDate;
    private LocalDate updateDate;
}

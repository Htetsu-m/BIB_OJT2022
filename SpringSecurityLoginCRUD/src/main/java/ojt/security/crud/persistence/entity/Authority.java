package ojt.security.crud.persistence.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 * <h2> Authority Class</h2>
 * <p>
 * Process for Displaying Authority
 * </p>
 * 
 * @author User
 *
 */
/**
 * <h2> setId</h2>
 * <p>
 * 
 * </p>
 *
 * @param id
 * @return void
 */
/**
 * <h2>setName</h2>
 * <p>
 * 
 * </p>
 *
 * @param name
 * @return void
 */
@Setter
/**
 * <h2>getId</h2>
 * <p>
 * 
 * </p>
 *
 * @return
 * @return Integer
 */
/**
 * <h2>getName</h2>
 * <p>
 * 
 * </p>
 *
 * @return
 * @return String
 */
@Getter
/**
 * <h2>Constructor for Authority</h2>
 * <p>
 * Constructor for Authority
 * </p>
 */
@NoArgsConstructor
/**
 * <h2>Constructor for Authority</h2>
 * <p>
 * Constructor for Authority
 * </p>
 * 
 * @param id
 * @param name
 */
@AllArgsConstructor
@Entity
@Table(name = "authorities")
public class Authority {
    /**
     * <h2>id</h2>
     * <p>
     * id
     * </p>
     */
    @Id
    @Column(name = "authority_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    /**
     * <h2>name</h2>
     * <p>
     * name
     * </p>
     */
    private String name;
}
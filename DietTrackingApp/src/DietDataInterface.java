import java.util.List;

public interface DietDataInterface {
	List<DietData> findByAccountID(int AccountID);
}

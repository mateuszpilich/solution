package dao;

import org.junit.Before;
import org.junit.Test;
import org.mockito.Mockito;

import java.sql.ResultSet;
import java.sql.SQLException;

import static org.junit.Assert.assertEquals;

public class DaoRepositoryImplTest {

    private DaoRepositoryImpl daoRepository;

    @Before
    public void init() {
        this.daoRepository = Mockito.spy(new DaoRepositoryImpl(null));
    }

    @Test
    public void totalRequestsNumber_1() throws SQLException {
        // given
        ResultSet resultSet = Mockito.mock(ResultSet.class);
        Mockito.doReturn(true).when(resultSet).next();
        Mockito.doReturn(Long.valueOf(14)).when(resultSet).getLong(Mockito.anyInt());

        // when
        Mockito.doReturn(resultSet).when(this.daoRepository).executeQuery(Mockito.anyString());
        Long result = daoRepository.totalRequestsNumber();

        // then
        assertEquals(Long.valueOf(14), result);
    }
}

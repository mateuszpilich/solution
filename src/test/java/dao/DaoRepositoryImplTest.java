package dao;

import org.junit.Before;
import org.junit.Test;
import org.mockito.Mockito;

import java.math.BigDecimal;
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

    @Test
    public void totalRequestsNumber_2() throws SQLException {
        // given
        ResultSet resultSet = Mockito.mock(ResultSet.class);
        Mockito.doReturn(true).when(resultSet).next();
        Mockito.doReturn(Long.valueOf(0)).when(resultSet).getLong(Mockito.anyInt());

        // when
        Mockito.doReturn(resultSet).when(this.daoRepository).executeQuery(Mockito.anyString());
        Long result = daoRepository.totalRequestsNumber();

        // then
        assertEquals(Long.valueOf(0), result);
    }

    @Test
    public void totalRequestsNumberByClientId_1() throws SQLException {
        // given
        ResultSet resultSet = Mockito.mock(ResultSet.class);
        Mockito.doReturn(true).when(resultSet).next();
        Mockito.doReturn(Long.valueOf(4)).when(resultSet).getLong(Mockito.anyInt());

        // when
        Mockito.doReturn(resultSet).when(this.daoRepository).executeQuery(Mockito.anyString());
        Long result = daoRepository.totalRequestsNumberByClientId(1L);

        // then
        assertEquals(Long.valueOf(4), result);
    }

    @Test
    public void totalRequestsNumberByClientId_2() throws SQLException {
        // given
        ResultSet resultSet = Mockito.mock(ResultSet.class);
        Mockito.doReturn(true).when(resultSet).next();
        Mockito.doReturn(Long.valueOf(0)).when(resultSet).getLong(Mockito.anyInt());

        // when
        Mockito.doReturn(resultSet).when(this.daoRepository).executeQuery(Mockito.anyString());
        Long result = daoRepository.totalRequestsNumberByClientId(1L);

        // then
        assertEquals(Long.valueOf(0), result);
    }

    @Test
    public void totalRequestsPrice_1() throws SQLException {
        // given
        ResultSet resultSet = Mockito.mock(ResultSet.class);
        Mockito.doReturn(true).when(resultSet).next();
        Mockito.doReturn(BigDecimal.valueOf(120.0).setScale(2,
                BigDecimal.ROUND_CEILING)).when(resultSet).getBigDecimal(Mockito.anyInt());

        // when
        Mockito.doReturn(resultSet).when(this.daoRepository).executeQuery(Mockito.anyString());
        BigDecimal result = daoRepository.totalRequestsPrice();

        // then
        assertEquals(BigDecimal.valueOf(120.0).setScale(2,
                BigDecimal.ROUND_CEILING), result);
    }

    @Test
    public void totalRequestsPrice_2() throws SQLException {
        // given
        ResultSet resultSet = Mockito.mock(ResultSet.class);
        Mockito.doReturn(true).when(resultSet).next();
        Mockito.doReturn(BigDecimal.valueOf(0.0).setScale(2,
                BigDecimal.ROUND_CEILING)).when(resultSet).getBigDecimal(Mockito.anyInt());

        // when
        Mockito.doReturn(resultSet).when(this.daoRepository).executeQuery(Mockito.anyString());
        BigDecimal result = daoRepository.totalRequestsPrice();

        // then
        Mockito.doReturn(BigDecimal.valueOf(0.0).setScale(2,
                BigDecimal.ROUND_CEILING)).when(resultSet).getBigDecimal(Mockito.anyInt());
    }

    @Test
    public void totalRequestsPriceByClientId_1() throws SQLException {
        // given
        ResultSet resultSet = Mockito.mock(ResultSet.class);
        Mockito.doReturn(true).when(resultSet).next();
        Mockito.doReturn(BigDecimal.valueOf(20.0).setScale(2,
                BigDecimal.ROUND_CEILING)).when(resultSet).getBigDecimal(Mockito.anyInt());

        // when
        Mockito.doReturn(resultSet).when(this.daoRepository).executeQuery(Mockito.anyString());
        BigDecimal result = daoRepository.totalRequestsPriceByClientId(1L);

        // then
        assertEquals(BigDecimal.valueOf(20.0).setScale(2,
                BigDecimal.ROUND_CEILING), result);
    }

    @Test
    public void totalRequestsPriceByClientId_2() throws SQLException {
        // given
        ResultSet resultSet = Mockito.mock(ResultSet.class);
        Mockito.doReturn(true).when(resultSet).next();
        Mockito.doReturn(BigDecimal.valueOf(0.0).setScale(2,
                BigDecimal.ROUND_CEILING)).when(resultSet).getBigDecimal(Mockito.anyInt());

        // when
        Mockito.doReturn(resultSet).when(this.daoRepository).executeQuery(Mockito.anyString());
        BigDecimal result = daoRepository.totalRequestsPriceByClientId(1L);

        // then
        Mockito.doReturn(BigDecimal.valueOf(0.0).setScale(2,
                BigDecimal.ROUND_CEILING)).when(resultSet).getBigDecimal(Mockito.anyInt());
    }

    @Test
    public void averageValueOfRequest_1() throws SQLException {
        // given
        ResultSet resultSet = Mockito.mock(ResultSet.class);
        Mockito.doReturn(true).when(resultSet).next();
        Mockito.doReturn(BigDecimal.valueOf(13.33).setScale(2,
                BigDecimal.ROUND_CEILING)).when(resultSet).getBigDecimal(Mockito.anyInt());

        // when
        Mockito.doReturn(resultSet).when(this.daoRepository).executeQuery(Mockito.anyString());
        BigDecimal result = daoRepository.averageValueOfRequest();

        // then
        assertEquals(BigDecimal.valueOf(13.33).setScale(2,
                BigDecimal.ROUND_CEILING), result);
    }

    @Test
    public void averageValueOfRequest_2() throws SQLException {
        // given
        ResultSet resultSet = Mockito.mock(ResultSet.class);
        Mockito.doReturn(true).when(resultSet).next();
        Mockito.doReturn(BigDecimal.valueOf(0.0).setScale(2,
                BigDecimal.ROUND_CEILING)).when(resultSet).getBigDecimal(Mockito.anyInt());

        // when
        Mockito.doReturn(resultSet).when(this.daoRepository).executeQuery(Mockito.anyString());
        BigDecimal result = daoRepository.averageValueOfRequest();

        // then
        Mockito.doReturn(BigDecimal.valueOf(0.0).setScale(2,
                BigDecimal.ROUND_CEILING)).when(resultSet).getBigDecimal(Mockito.anyInt());
    }

    @Test
    public void averageValueOfRequestToClientById_1() throws SQLException {
        // given
        ResultSet resultSet = Mockito.mock(ResultSet.class);
        Mockito.doReturn(true).when(resultSet).next();
        Mockito.doReturn(BigDecimal.valueOf(11.67).setScale(2,
                BigDecimal.ROUND_CEILING)).when(resultSet).getBigDecimal(Mockito.anyInt());

        // when
        Mockito.doReturn(resultSet).when(this.daoRepository).executeQuery(Mockito.anyString());
        BigDecimal result = daoRepository.averageValueOfRequestToClientById(1L);

        // then
        assertEquals(BigDecimal.valueOf(11.67).setScale(2,
                BigDecimal.ROUND_CEILING), result);
    }

    @Test
    public void averageValueOfRequestToClientById_2() throws SQLException {
        // given
        ResultSet resultSet = Mockito.mock(ResultSet.class);
        Mockito.doReturn(true).when(resultSet).next();
        Mockito.doReturn(BigDecimal.valueOf(0.0).setScale(2,
                BigDecimal.ROUND_CEILING)).when(resultSet).getBigDecimal(Mockito.anyInt());

        // when
        Mockito.doReturn(resultSet).when(this.daoRepository).executeQuery(Mockito.anyString());
        BigDecimal result = daoRepository.averageValueOfRequestToClientById(1L);

        // then
        Mockito.doReturn(BigDecimal.valueOf(0.0).setScale(2,
                BigDecimal.ROUND_CEILING)).when(resultSet).getBigDecimal(Mockito.anyInt());
    }
}

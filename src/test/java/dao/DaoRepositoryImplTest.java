package dao;

import domain.Request;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mockito;

import java.math.BigDecimal;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import static org.junit.Assert.assertEquals;

public class DaoRepositoryImplTest {

    private DaoRepositoryImpl daoRepository;

    @Before
    public void init() {
        this.daoRepository = Mockito.spy(new DaoRepositoryImpl(null));
    }

    @Test
    public void testShouldGiveTotalRequestsNumber_1() throws SQLException {
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
    public void testShouldGiveTotalRequestsNumber_2() throws SQLException {
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
    public void testShouldGiveTotalRequestsNumberByClientId_1() throws SQLException {
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
    public void testShouldGiveTotalRequestsNumberByClientId_2() throws SQLException {
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
    public void testShouldGiveTotalRequestsPrice_1() throws SQLException {
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
    public void testShouldGiveTotalRequestsPrice_2() throws SQLException {
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
    public void testShouldGiveTotalRequestsPriceByClientId_1() throws SQLException {
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
    public void testShouldGiveTotalRequestsPriceByClientId_2() throws SQLException {
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
    public void testShouldGiveAverageValueOfRequest_1() throws SQLException {
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
    public void testShouldGiveAverageValueOfRequest_2() throws SQLException {
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
    public void testShouldGiveAverageValueOfRequestToClientById_1() throws SQLException {
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
    public void testShouldGiveAverageValueOfRequestToClientById_2() throws SQLException {
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

    @Test
    public void testShouldGiveListOfAllRequests_1() throws SQLException {
        // given
        ResultSet resultSet = Mockito.mock(ResultSet.class);
        Mockito.doReturn(true).doReturn(false).when(resultSet).next();
        Mockito.doReturn(resultSet).when(daoRepository).executeQuery("SELECT " +
                "* FROM REQUEST");

        // when
        Mockito.doReturn(new Request()).when(daoRepository).prepareRequest(Mockito.any());
        List<Request> result = daoRepository.listOfAllRequests();

        // then
        assertEquals(1, result.size());
    }

    @Test
    public void testShouldGiveListOfAllRequests_2() throws SQLException {
        // given
        ResultSet resultSet = Mockito.mock(ResultSet.class);
        Mockito.doReturn(true).doReturn(true).doReturn(true).doReturn(true).doReturn(false).when(resultSet).next();
        Mockito.doReturn(resultSet).when(daoRepository).executeQuery("SELECT " +
                "* FROM REQUEST");

        // when
        Mockito.doReturn(new Request()).when(daoRepository).prepareRequest(Mockito.any());
        List<Request> result = daoRepository.listOfAllRequests();

        // then
        assertEquals(4, result.size());
    }

    @Test
    public void testShouldGiveListOfAllRequestsToClientById_1() throws SQLException {
        // given
        ResultSet resultSet = Mockito.mock(ResultSet.class);
        Mockito.doReturn(true).doReturn(false).when(resultSet).next();
        Mockito.doReturn(resultSet).when(daoRepository).executeQuery("SELECT " +
                "* FROM REQUEST WHERE clientId = 13;");

        // when
        Mockito.doReturn(new Request()).when(daoRepository).prepareRequest(Mockito.any());
        List<Request> result = daoRepository.listOfAllRequestsToClientById(13L);

        // then
        assertEquals(1, result.size());
    }

    @Test
    public void testShouldGiveListOfAllRequestsToClientById_2() throws SQLException {
        // given
        ResultSet resultSet = Mockito.mock(ResultSet.class);
        Mockito.doReturn(true).doReturn(true).doReturn(true).doReturn(false).when(resultSet).next();
        Mockito.doReturn(resultSet).when(daoRepository).executeQuery("SELECT " +
                "* FROM REQUEST WHERE clientId = 13;");

        // when
        Mockito.doReturn(new Request()).when(daoRepository).prepareRequest(Mockito.any());
        List<Request> result = daoRepository.listOfAllRequestsToClientById(13L);

        // then
        assertEquals(3, result.size());
    }

    @Test
    public void testShouldGiveExecuteQuery_1() throws SQLException {
        // given
        ResultSet resultSet = Mockito.mock(ResultSet.class);
        Mockito.doReturn(true).doReturn(false).when(resultSet).next();
        Mockito.doReturn(resultSet).when(daoRepository).executeQuery("SELECT " +
                "* FROM REQUEST");

        // when
        ResultSet result = daoRepository.executeQuery("SELECT * FROM REQUEST");

        // then
        assertEquals(resultSet, result);
    }
}

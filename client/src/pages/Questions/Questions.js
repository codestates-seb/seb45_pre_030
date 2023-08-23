import AskButton from '../../components/questionList/AskButton/AskButton';
import {
  Container,
  FilterWrapper,
  QuestionList,
  Section,
  SectionContainer,
  SubContainer,
  SubWrapper,
  Title,
  TitleWrapper,
  Total,
} from './Questions.styled';
import SideBar from '../../components/questionList/SideBar/SideBar';
import FilterButton from '../../components/questionList/FilterButton/FilterButton';
import FilterOption from '../../components/questionList/FilterOption/FilterOption';
import Question from '../../components/questionList/Question/Question';
import SortButton from '../../components/questionList/SortButton/SortButton';
import Nav from '../../components/Nav/Nav';
import { Link, useLocation } from 'react-router-dom';
import { useEffect } from 'react';
import Paging from '../../components/questionList/Paging/Paging';
import { fetchQuestions } from '../../api/api';
import { useDispatch, useSelector } from 'react-redux';
import { setCurrentPage, setFetchedData } from '../../redux/actions';

function Questions() {
  const fetchedData = useSelector((state) => state.fetchedData);
  const dispatch = useDispatch();
  const pageSize = 15;

  const location = useLocation(); // useLocation을 이용하여 현재 URL 정보 가져오기
  const queryParams = new URLSearchParams(location.search);
  let currentPageFromQueryParam = queryParams.get('page');

  if (!currentPageFromQueryParam) {
    currentPageFromQueryParam = 1;
  }

  useEffect(() => {
    fetchQuestions(currentPageFromQueryParam, pageSize)
      .then((data) => {
        dispatch(setFetchedData(data));
      })
      .catch((error) => {
        console.error(error);
      });
  }, [currentPageFromQueryParam, dispatch]);

  const handlePageChange = (pageNumber) => {
    dispatch(setCurrentPage(pageNumber));
  };

  return (
    <Container>
      <SectionContainer>
        <Section className="questions-nav-section">
          <Nav />
        </Section>
        <Section className="questions-main-section">
          <TitleWrapper>
            <Title>All Questions</Title>
            <Link to="/ask">
              <AskButton />
            </Link>
          </TitleWrapper>
          <SubContainer>
            <SubWrapper>
              <Total>{fetchedData.pageInfo.totalElements} questions</Total>
              <FilterWrapper>
                <SortButton />
                <FilterButton />
              </FilterWrapper>
            </SubWrapper>
            <FilterOption />
          </SubContainer>
          <QuestionList>
            {fetchedData.data.map((data) => (
              <Question key={data.questionId} data={data} />
            ))}
          </QuestionList>
          <Paging
            page={fetchedData.pageInfo}
            onPageChange={handlePageChange}
            currentPageFromQueryParam={Number(currentPageFromQueryParam)}
          />
        </Section>
        <Section className="questions-side-section">
          <SideBar />
        </Section>
      </SectionContainer>
    </Container>
  );
}

export default Questions;

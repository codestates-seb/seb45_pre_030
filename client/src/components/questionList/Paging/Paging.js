import PropTypes from 'prop-types';
import { Container, Page } from './Paging.styled';
import { Link } from 'react-router-dom';

function Paging({ page, onPageChange, currentPageFromQueryParam }) {
  const totalPages = page.totalPages;
  const pageNumbers = [];

  for (let pageNumber = 1; pageNumber <= totalPages; pageNumber++) {
    pageNumbers.push(pageNumber);
  }

  return (
    <Container>
      {pageNumbers.map((el) => (
        <Link to={`/?page=${el}`} key={el} onClick={() => onPageChange(el)}>
          <Page
            className={
              (currentPageFromQueryParam === 0 && el == 1) ||
              currentPageFromQueryParam === el
                ? 'currentPage'
                : ''
            }
          >
            {el}
          </Page>
        </Link>
      ))}
    </Container>
  );
}

Paging.propTypes = {
  page: PropTypes.object.isRequired,
  onPageChange: PropTypes.func.isRequired,
  currentPageFromQueryParam: PropTypes.number.isRequired,
};

export default Paging;

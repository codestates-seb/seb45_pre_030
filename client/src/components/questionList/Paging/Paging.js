import PropTypes from 'prop-types';
import { Container, Page } from './Paging.styled';
import { Link } from 'react-router-dom';

function Paging({ page, onPageChange, currentPage }) {
  const totalPages = page.totalPages;
  const pageNumbers = [];

  for (let pageNumber = 1; pageNumber <= totalPages; pageNumber++) {
    pageNumbers.push(pageNumber);
  }

  return (
    <Container>
      {pageNumbers.map((el) => (
        <Link to={`/?page=${el}`} key={el} onClick={() => onPageChange(el)}>
          <Page className={currentPage === el ? 'currentPage' : ''}>{el}</Page>
        </Link>
      ))}
    </Container>
  );
}

Paging.propTypes = {
  page: PropTypes.object.isRequired,
  onPageChange: PropTypes.func.isRequired,
  currentPage: PropTypes.number.isRequired,
};

export default Paging;

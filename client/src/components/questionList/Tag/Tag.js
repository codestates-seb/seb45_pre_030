import { Container, P } from './Tag.styled';
import PropTypes from 'prop-types';

function Tag({ tag }) {
  return (
    <Container>
      <P>{tag}</P>
    </Container>
  );
}

Tag.propTypes = {
  tag: PropTypes.string.isRequired,
};

export default Tag;

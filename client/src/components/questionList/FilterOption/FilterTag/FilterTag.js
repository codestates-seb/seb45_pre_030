import PropTypes from 'prop-types';
import { Button, Container, Name } from './FilterTag.styled';
import { faXmark } from '@fortawesome/free-solid-svg-icons';
import { FontAwesomeIcon } from '@fortawesome/react-fontawesome';
import { useDispatch } from 'react-redux';
import { deleteFilterTag } from '../../../../redux/actions';

function FilterTag({ tag }) {
  const dispatch = useDispatch();

  const handleTagDelete = () => {
    dispatch(deleteFilterTag(tag));
  };

  return (
    <Container key={tag}>
      <Name>{tag}</Name>
      <Button onClick={handleTagDelete}>
        <FontAwesomeIcon icon={faXmark} />
      </Button>
    </Container>
  );
}

// props 유효성 검사
FilterTag.propTypes = {
  tag: PropTypes.string.isRequired,
};

export default FilterTag;

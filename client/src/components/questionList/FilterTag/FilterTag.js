import { Button, Container, Name } from './FilterTag.styled';
import { faXmark } from '@fortawesome/free-solid-svg-icons';
import { FontAwesomeIcon } from '@fortawesome/react-fontawesome';

function FilterTag() {
  return (
    <Container>
      <Name>java</Name>
      <Button>
        <FontAwesomeIcon icon={faXmark} />
      </Button>
    </Container>
  );
}

export default FilterTag;

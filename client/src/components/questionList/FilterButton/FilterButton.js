import { Button } from './FilterButton.styled';
import { faFilter } from '@fortawesome/free-solid-svg-icons';
import { FontAwesomeIcon } from '@fortawesome/react-fontawesome';
import { useDispatch } from 'react-redux';
import { toggleFilterOption } from '../../../redux/actions';

function FilterButton() {
  const dispatch = useDispatch();

  const handleFilterButtonClick = () => {
    dispatch(toggleFilterOption());
  };

  return (
    <Button onClick={handleFilterButtonClick}>
      <FontAwesomeIcon icon={faFilter} />
      &nbsp;Filter
    </Button>
  );
}

export default FilterButton;

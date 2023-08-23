import PropTypes from 'prop-types';
import { AnswerH2, ListContainer, ListBox } from './ASList.styled';
import ASMap from './ASMap';

function ASList({ answerlist, onDelete, onEdit }) {
  return (
    <ListContainer>
      <AnswerH2>{answerlist.length} Answer</AnswerH2>
      <ListBox>
        {answerlist.map((el) => {
          return (
            <ASMap
              key={el.id}
              {...el}
              onDelete={onDelete}
              onEdit={onEdit}
            ></ASMap>
          );
        })}
      </ListBox>
    </ListContainer>
  );
}

ASList.propTypes = {
  answerlist: PropTypes.string.isRequired,
  onDelete: PropTypes.string.isRequired,
  onEdit: PropTypes.string.isRequired,
};

export default ASList;

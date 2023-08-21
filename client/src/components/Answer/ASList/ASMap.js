import PropTypes from 'prop-types';
import {
  Answer,
  AnswerH4,
  AnswerBox,
  ASBox,
  ASButton,
  ASTextArea,
  ASButtonBox,
  ASDateBox,
  ASTextBox,
} from './ASList.styled';
import { useState, useRef } from 'react';

function ASMap({ content, date, id, onDelete, onEdit }) {
  const [Edit, setEdit] = useState(false);
  const [editContent, setEditContent] = useState(content);

  const EditRef = useRef();

  const HandleDelete = () => {
    if (window.confirm('정말 삭제 하시겠습니까?')) {
      onDelete(id);
    }
  };

  const HandleEdit = () => {
    setEdit(!Edit);
  };

  const HandleQuiteEdit = () => {
    setEdit(false);
    setEditContent(content);
  };

  const HandleOnEdit = () => {
    if (editContent.length < 1) {
      EditRef.current.focus();
      return;
    }
    if (window.confirm('정말 수정 하시겠습니까?')) {
      onEdit(id, editContent);
      HandleEdit();
    }
  };

  return (
    <Answer>
      <AnswerBox>
        <AnswerH4>이름</AnswerH4>
      </AnswerBox>
      <AnswerBox>
        <AnswerBox>
          {Edit ? (
            <ASTextArea
              ref={EditRef}
              value={editContent}
              onChange={(e) => setEditContent(e.target.value)}
            ></ASTextArea>
          ) : (
            <ASTextBox>{content}</ASTextBox>
          )}
        </AnswerBox>
      </AnswerBox>
      <ASBox>
        {Edit ? (
          <ASButtonBox>
            <ASButton onClick={HandleOnEdit}>Save</ASButton>
            <ASButton onClick={HandleQuiteEdit}>Quite</ASButton>
          </ASButtonBox>
        ) : (
          <ASButtonBox>
            <ASButton onClick={HandleEdit}>Edit</ASButton>
            <ASButton onClick={HandleDelete}>Delete</ASButton>
          </ASButtonBox>
        )}
        <ASDateBox>{date}</ASDateBox>
      </ASBox>
    </Answer>
  );
}

ASMap.propTypes = {
  content: PropTypes.string.isRequired,
  id: PropTypes.string.isRequired,
  onDelete: PropTypes.string.isRequired,
  onEdit: PropTypes.string.isRequired,
  date: PropTypes.string.isRequired,
};

export default ASMap;

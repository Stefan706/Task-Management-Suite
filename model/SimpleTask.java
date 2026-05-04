    package org.tucn.pt.model;

    public non-sealed class SimpleTask extends Task
    {
        protected int startHour;
        protected int endHour;
        public SimpleTask(int idTask, String statusTask, int startHour, int endHour)
        {
            super(idTask,statusTask);
            this.startHour=startHour;
            this.endHour=endHour;
        }
        @Override
        public int estimateDuration()
        {
            return endHour-startHour;
        }
    }
